using System;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0009
    {
        public static int Solve()
        {
            for (var a = 998; a > 0; a--)
            {
                var limit = (1000 - a) / 2;
                for (var b = 1000 - a - 1; b > limit; b--)
                {
                    var c = 1000 - a - b;
                    if (b * b + c * c == a * a)
                    {
                        return a * b * c;
                    }
                }
            }

            return 1;
        }
    }
}