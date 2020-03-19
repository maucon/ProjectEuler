using System;
using System.Diagnostics;
using System.Globalization;
using System.Reflection;
using System.Threading;

namespace ProjectEuler.main.csharp
{
    public class Starter
    {
        private static void Main(string[] args)
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.CreateSpecificCulture("en-US");
            Console.WriteLine("\nC# CLI started...\n");
            while (true)
            {
                try
                {
                    var input = Console.ReadLine();
                    if (input.Equals("exit"))
                    {
                        Console.WriteLine("\nC# CLI closed!");
                        return;
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
                            var startTime = Stopwatch.GetTimestamp();
                            var result = toInvoke.Invoke(null, null);
                            var totalTime = Stopwatch.GetTimestamp() - startTime;

                            var time = totalTime + "";
                            while (time.Length < 11) time = "0" + time;
                            for (var i = time.Length - 3; i > 0; i -= 3)
                            {
                                time = time.Substring(0, i) + ":" + time.Substring(i);
                            }

                            Console.WriteLine("Solution: " + result);
                            Console.WriteLine("Time:     " + time);
                            Console.WriteLine("         [ s| ms| μs| ns]");
                        }
                    }
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("Problem not solved yet!");
                        Console.ResetColor();
                    }
                }
                catch (Exception)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("Invalid command!");
                    Console.ResetColor();
                }
            }
        }
    }
}