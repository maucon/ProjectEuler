using System;
using System.Collections.Generic;
using System.Linq;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0060
    {
        public static int Solve()
        {
            var pairs = new Dictionary<int, List<int>>();
            var primeList = Primes(10000);

            for (var a = 0; a < primeList.Count - 1; a++)
            for (var b = a + 1; b < primeList.Count; b++)
                if (IsPrime(Convert.ToInt64(primeList[a] + "" + primeList[b])) && IsPrime(Convert.ToInt64(primeList[b] + "" + primeList[a])))
                {
                    if (pairs.ContainsKey(primeList[a]))
                    {
                        var list = pairs[primeList[a]];
                        list.Add(primeList[b]);
                        pairs[primeList[a]] = list;
                    }
                    else
                    {
                        pairs[primeList[a]] = new List<int> {primeList[b]};
                    }
                }

            return (from pair in pairs
                from pairValue in pair.Value
                where pairs.ContainsKey(pairValue)
                from pV in pair.Value.SkipWhile(p => p <= pairValue)
                from pVv in pairs[pairValue]
                where pV == pVv
                from p1 in pairs[pair.Key].SkipWhile(p => p <= pV)
                from p2 in pairs[pairValue].SkipWhile(p => p <= pV)
                where pairs.ContainsKey(pV)
                from p3 in pairs[pV].SkipWhile(p => p <= pV)
                where p1 == p2 && p2 == p3
                from pls1 in pairs[pair.Key].SkipWhile(p => p <= p1)
                from pls2 in pairs[pairValue].SkipWhile(p => p <= p1)
                from pls3 in pairs[pV].SkipWhile(p => p <= p1)
                where pairs.ContainsKey(p1)
                from pls4 in pairs[p1].SkipWhile(p => p <= p1)
                where pls1 == pls2 && pls2 == pls3 && pls3 == pls4
                select pair.Key + pairValue + pV + p1 + pls1).Concat(new[] {int.MaxValue}).Min();
        }

        private static List<int> Primes(int upper)
        {
            var pS = new bool[upper];
            var pL = new List<int>();

            var sqrt = (int) Math.Sqrt(pS.Length);
            for (var i = 3;
                i < sqrt;
                i += 2)
                if (!pS[i])
                {
                    pL.Add(i);

                    for (var j = i * i; j < pS.Length; j += i * 2) pS[j] = true;
                }

            for (var i = ((sqrt + 1) & 1) == 0 ? sqrt + 2 : sqrt + 1;
                i < pS.Length;
                i += 2)
                if (!pS[i])
                    pL.Add(i);
            return pL;
        }

        private static bool IsPrime(long n)
        {
            var nsqrt = Math.Sqrt(n);
            for (var i = 3;
                i < nsqrt;
                i += 2)
                if (n % i == 0)
                    return false;

            return true;
        }
    }
}