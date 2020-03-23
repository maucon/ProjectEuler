using System;
using System.Collections.Generic;
using System.Numerics;

namespace ProjectEuler.main.csharp.p05
{
    public class Problem0500
    {
        public static int Solve()
        {
            const int limit = 8300000;
            var primes = Primes(limit);
            BigInteger solution = 1;

            for (var i = 0; i < primes.Count; i++)
            {
                solution *= primes[0];
                solution %= 500500507;

                var num = primes[0] * primes[0];
                primes.Remove(primes[0]);

                var j = 0;
                while (j < primes.Count && num > primes[j])
                {
                    j++;
                }

                primes.Insert(j, num);
            }

            return (int) solution;
        }

        private static List<ulong> Primes(int upper)
        {
            var primeSieve = new bool[upper];
            var primeList = new List<ulong> {2};

            var sqrt = (int) Math.Sqrt(primeSieve.Length);
            for (var i = 3; i < sqrt; i += 2)
                if (!primeSieve[i])
                {
                    primeList.Add(Convert.ToUInt64(i));

                    for (var j = i * i; j < primeSieve.Length; j += i * 2) primeSieve[j] = true;
                }

            for (var i = ((sqrt + 1) & 1) == 0 ? sqrt + 2 : sqrt + 1; i < upper && primeList.Count < 500500; i += 2)
            {
                if (!primeSieve[i]) primeList.Add(Convert.ToUInt64(i));
            }

            return primeList;
        }
    }
}