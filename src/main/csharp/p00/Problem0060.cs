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

            var result = int.MaxValue;
            foreach (var pair in pairs)
            foreach (var pairValue in pair.Value)
                if (pairs.ContainsKey(pairValue))
                    foreach (var pV in pair.Value.SkipWhile(p => p <= pairValue))
                    foreach (var pVv in pairs[pairValue])
                        if (pV == pVv)
                            //FOUND PAIR OF 3 -> Console.WriteLine(pair.Key + ":" + pairValue + ":" + pV);
                            foreach (var p1 in pairs[pair.Key].SkipWhile(p => p <= pV))
                            foreach (var p2 in pairs[pairValue].SkipWhile(p => p <= pV))
                                if (pairs.ContainsKey(pV))
                                    foreach (var p3 in pairs[pV].SkipWhile(p => p <= pV))
                                        if (p1 == p2 && p2 == p3)
                                            //FOUND PAIR OF 4 -> Console.WriteLine(pair.Key + ":" + pairValue + ":" + pV + ":" + p1);
                                            foreach (var pls1 in pairs[pair.Key].SkipWhile(p => p <= p1))
                                            foreach (var pls2 in pairs[pairValue].SkipWhile(p => p <= p1))
                                            foreach (var pls3 in pairs[pV].SkipWhile(p => p <= p1))
                                                if (pairs.ContainsKey(p1))
                                                    foreach (var pls4 in pairs[p1].SkipWhile(p => p <= p1))
                                                        if (pls1 == pls2 && pls2 == pls3 && pls3 == pls4)
                                                            //FOUND PAIR OF 5
                                                            if (pair.Key + pairValue + pV + p1 + pls1 < result)
                                                                result = pair.Key + pairValue + pV + p1 + pls1;

            return result;
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