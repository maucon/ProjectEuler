namespace ProjectEuler.main.csharp.p00
{
    public class Problem0005
    {
        public static int Solve()
        {
            int[] val = {3, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19};
            for (var i = 20; true; i += 20)
            {
                var found = true;
                foreach (var v in val)
                {
                    if (i % v != 0)
                    {
                        found = false;
                        break;
                    }
                }

                if (found)
                {
                    return i;
                }
            }
        }
    }
}