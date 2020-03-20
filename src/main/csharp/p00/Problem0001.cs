namespace ProjectEuler.main.csharp.p00
{
    public class Problem0001
    {
        public static int Solve()
        {
            var sum = 0;
            for (var i = 0; i < 1000; i++)
                if (i % 3 == 0 || i % 5 == 0)
                    sum += i;

            return sum;
        }
    }
}