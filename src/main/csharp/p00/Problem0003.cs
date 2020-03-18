namespace ProjectEuler.main.csharp.p00
{
    public class Problem0003
    {
        public static long Solve()
        {
            var num = 600851475143;

            for (var i = 2; i < num - 1; i++)
            {
                if (num % i == 0)
                {
                    num /= i;
                    i--;
                }
            }

            return num;
        }
    }
}