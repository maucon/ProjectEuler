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
            while (true)
            {
                //TODO: CALL FROM JAVA AND GET PROBLEM NUMBER AS ARG
                Console.WriteLine("\nC# CLI started...");
                var input = Console.ReadLine();
                if (input.Equals("0")) return;

                //start Problems:1
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
            }
        }
    }
}