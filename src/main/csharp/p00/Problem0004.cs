using System;
using System.Linq;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0004
    {
        public static int Solve()
        {
            var res = 0;
            for (var i = 999; i > 99; i--)
            {
                for (var j = i; j > 99; j--)
                {
                    var num = i * j;
                    if (num < res) break;
                    var s = num + "";
                    if (s.Equals(Reverse(s)))
                    {
                        res = num;
                    }
                }
            }

            return res;
        }

        private static string Reverse(string s)
        {
            var charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}