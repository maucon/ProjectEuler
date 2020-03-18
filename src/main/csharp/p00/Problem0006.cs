namespace ProjectEuler.main.csharp.p00
{
    public class Problem0006
    {
        public static int Solve()
        {
            var sum1 = 0;
            var sum2 = 0;

            for (var i = 1; i <= 100; i++)
            {
                sum1 += i * i;
                sum2 += i;
            }

            return sum2 * sum2 - sum1;
        }
    }
}