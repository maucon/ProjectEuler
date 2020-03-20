using System;
using System.Collections.Generic;
using System.Linq;

namespace ProjectEuler.main.csharp.p00
{
    public class Problem0060
    {
        private static bool[] _primeSieve;
        private static List<int> _primeList;

        public static int Solve()
        {
            var pairs = new Dictionary<int, List<int>>();
            Primes(10000 * 10000);

            for (var a = 0; a < _primeList.Count - 1; a++)
            for (var b = a + 1; b < _primeList.Count; b++)
                if (!_primeSieve[Convert.ToInt64(_primeList[a] + "" + _primeList[b])] && !_primeSieve[Convert.ToInt64(_primeList[b] + "" + _primeList[a])])
                {
                    if (pairs.ContainsKey(_primeList[a]))
                        pairs[_primeList[a]].Add(_primeList[b]);
                    else
                        pairs[_primeList[a]] = new List<int> {_primeList[b]};
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

        private static void Primes(int upper)
        {
            _primeSieve = new bool[upper];
            _primeList = new List<int>();

            var sqrt = (int) Math.Sqrt(_primeSieve.Length);
            for (var i = 3;
                i < sqrt;
                i += 2)
                if (!_primeSieve[i])
                {
                    _primeList.Add(i);

                    for (var j = i * i; j < _primeSieve.Length; j += i * 2) _primeSieve[j] = true;
                }
        }
    }
}