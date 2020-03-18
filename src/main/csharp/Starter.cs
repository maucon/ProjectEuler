using System;
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
            Console.WriteLine("\nC# CLI started...");
            while (true)
            {
                try
                {
                    var input = Console.ReadLine();
                    if (input.Equals("exit")) return;

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
                            Console.WriteLine("SOLUTION:" + toInvoke.Invoke(null, null));
                        }
                    }
                    else
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("Problem not solved yet!");
                        Console.ResetColor();
                    }
                }
                catch (Exception e)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine("Invalid command!");
                    Console.ResetColor();
                }
            }

            Console.WriteLine("\nC# CLI closed!");
        }
    }
}