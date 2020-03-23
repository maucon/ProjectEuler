namespace ProjectEuler.main.csharp.p00
{
    public class Problem0009
    {
        public static int Solve()
        {
            for (var x = 998; x > 0; x--)
            {
                var limit = (1000 - x) / 2;
                for (var y = 1000 - x - 1; y > limit; y--)
                {
                    var z = 1000 - x - y;
                    if (y * y + z * z == x * x) return x * y * z;
                }
            }

            return 1;
        }
    }
}