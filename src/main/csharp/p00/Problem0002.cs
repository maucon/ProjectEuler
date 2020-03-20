namespace ProjectEuler.main.csharp.p00
{
    public class Problem0002
    {
        public static int Solve()
        {
            var sum = 0;
            var fib1 = 1;
            var fib2 = 1;

            while (fib2 <= 4000000)
                if (((fib1 = fib2 + (fib2 = fib1)) & 1) == 0)
                    sum += fib1;

            return sum;
        }
    }
}