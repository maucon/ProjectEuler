using System;
using System.Diagnostics;
using System.Globalization;
using System.Linq;
using System.Reflection;
using System.Text.RegularExpressions;
using System.Threading;
using HtmlAgilityPack;


namespace ProjectEuler.main.csharp
{
    public class Starter
    {
        private static void Main(string[] args)
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.CreateSpecificCulture("en-US");
            Console.WriteLine("\nC# CLI started...");
            while (true)
                try
                {    
                    Console.Write("=> ");
                    var input = Console.ReadLine();
                    if (input.Equals("exit"))
                    {
                        Console.WriteLine("\nC# CLI closed!");
                        return;
                    }

                    try
                    {
                        Console.WriteLine("--Problem " + input + "--\n");
                        Console.WriteLine(Regex.Replace(new HtmlWeb().Load("https://projecteuler.net/problem=" + input).DocumentNode.SelectNodes("//div[@class='problem_content']")[0]
                            .InnerText.Replace(". ", ".\n"), @"^\s+$[\r\n]*", string.Empty, RegexOptions.Multiline));
                    }
                    catch (Exception)
                    {
                        ErrPrint("Can't find problem description!");
                        continue;
                    }

                    //start Problems:
                    var package = Convert.ToString(Convert.ToInt32(input) / 100);
                    var path = "ProjectEuler.main.csharp.p" + new string('0', 2 - package.Length) + package + ".Problem" + new string('0', 4 - input.Length) + input;
                    var problem = Type.GetType(path);

                    if (problem != null)
                    {
                        var problemObject = Activator.CreateInstance(problem);
                        var toInvoke = problemObject.GetType().GetMethod("Solve", BindingFlags.Static | BindingFlags.Public);
                        if (toInvoke != null)
                        {
                            var startTime = GetNanoseconds();
                            var result = toInvoke.Invoke(null, null);
                            var totalTime = GetNanoseconds() - startTime;

                            var time = totalTime + "";
                            while (time.Length < 11) time = "0" + time;
                            for (var i = time.Length - 3; i > 0; i -= 3) time = time.Substring(0, i) + ":" + time.Substring(i);

                            Console.WriteLine("Solution: " + result);
                            Console.WriteLine("Time:     " + time);
                            Console.WriteLine("         [ s| ms| μs| ns]");
                        }
                    }
                    else
                    {
                        ErrPrint("Problem not solved yet!");
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine(e + "\n");
                    ErrPrint("Problem not solved yet!");
                }
        }

        private static void ErrPrint(string message)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine(message);
            Console.ResetColor();
        }

        private static long GetNanoseconds()
        {
            var timestamp = Stopwatch.GetTimestamp();
            var nanoseconds = 1_000_000_000.0 * timestamp / Stopwatch.Frequency;

            return (long) nanoseconds;
        }
    }
}