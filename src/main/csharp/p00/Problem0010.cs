using System;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0010
    {
        public static long Solve()
        {
            var primeSieve = new bool[2000000];
            var limit = Math.Sqrt(primeSieve.Length);
            long sum = 2;

            for (var i = 3; i < limit; i += 2)
                if (!primeSieve[i])
                {
                    sum += i;

                    for (var j = i * i; j < 2000000; j += i * 2) primeSieve[j] = true;
                }

            for (var i = (int) limit + 1; i < 2000000; i += 2)
                if (!primeSieve[i])
                    sum += i;


            return sum;
        }
    }
}