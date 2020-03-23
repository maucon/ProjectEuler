using System;
using System.Collections.Generic;

namespace ProjectEuler.main.csharp.p05
{
    public class Problem0500
    {
        private const int Limit = 7376508; // 7376507 is 500500st prime

        public static ulong Solve()
        {
            var allPrimeSqrt = AllPrimeSqrt(Primes(Limit));
            allPrimeSqrt.Sort();

            ulong solution = 1;
            for (var i = 0; i < 500500; i++)
            {
                solution = solution * Convert.ToUInt64(allPrimeSqrt[i]) % 500500507;
            }

            return solution;
        }

        private static List<int> AllPrimeSqrt(List<int> primes)
        {
            var pLimit = Limit;
            for (var i = 2; i < 17; i *= 2)
            {
                pLimit = (int) Math.Sqrt(pLimit);
                for (var j = 0; primes[j] < pLimit + 1; j++) primes.Add(IntPow(primes[j], i));
            }

            return primes;
        }

        private static List<int> Primes(int upper)
        {
            var primeSieve = new bool[upper];
            var primeList = new List<int> {2};

            var sqrt = (int) Math.Sqrt(primeSieve.Length);
            for (var i = 3; i < sqrt; i += 2)
                if (!primeSieve[i])
                {
                    primeList.Add(i);

                    for (var j = i * i; j < primeSieve.Length; j += i * 2) primeSieve[j] = true;
                }

            for (var i = ((sqrt + 1) & 1) == 0 ? sqrt + 2 : sqrt + 1; i < upper && primeList.Count < 500500; i += 2)
                if (!primeSieve[i])
                    primeList.Add(i);

            return primeList;
        }

        private static int IntPow(int x, int pow)
        {
            var ret = 1;
            while (pow != 0)
            {
                if ((pow & 1) == 1)
                    ret *= x;
                x *= x;
                pow >>= 1;
            }

            return ret;
        }
    }
}