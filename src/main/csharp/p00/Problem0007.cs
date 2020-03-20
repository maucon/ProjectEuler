using System;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0007
    {
        public static int Solve()
        {
            var count = 2;
            int i;
            for (i = 5; count < 10001; i++)
            {
                if ((i & 1) == 0) continue;

                var found = true;
                var sqrt = Math.Sqrt(i);
                for (var j = 3; j <= sqrt; j += 2)
                    if (i % j == 0)
                    {
                        found = false;
                        break;
                    }

                if (found) count++;
            }

            return i - 1;
        }
    }
}