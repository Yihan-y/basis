The characteristics of the knapsack problem: 
Given a target, the target can be a number or a string, 
and then given an array, which may contain numbers or strings.

Question: Can you use the elements of the array to do various permutations and combinations to get the target?

Detailed analysis has been carried out in the code.

In case one still cannot fully understand the whole process, a brief conclusion here:

State transition equation and its derivation process on complete knapsack problem:

1. combination:

two-dimension:
dp[i][j]=dp[i-1][j-0*w]+dp[i-1][j-w]+dp[i-1][j-2w]+...+dp[i-1][j-k*w];
since dp[i][j-w]=dp[i-1][j-w-0*w]+dp[i-1][j-w-w]+...+dp[i-1][j-w-(k-1)*w];
so dp[i][j]=dp[i-1][j]+dp[i][j-w]

one-dimension:
dp[j]+=dp[j-w]

2. true or false:

two-dimension:
dp[i][j]=dp[i-1][j]||dp[i-1][j-w]||dp[i-1][j-2w]||...||dp[i-1][j-k*w];
since dp[i][j-w]=dp[i-1][j-w-0*w]||dp[i-1][j-w-w]||...||dp[i-1][j-w-(k-1)*w];
so dp[i][j]=dp[i-1][j]||dp[i][j-w]

one-dimension:
dp[j]=dp[j]||dp[j-w]

3. max or min:

two-dimension:
dp[i][j]=Max/Min(dp[i-1][j],dp[i-1][j-w]+v,dp[i-1][j-2w]+2v,...,dp[i-1][j-k*w]+k*v);
since dp[i][j-w]=Max/Min(dp[i-1][j-w],dp[i-1][j-2w]+v,...,dp[i-1][j-k*w]+(k-1)*v);
so dp[i][j]=Max/Min(dp[i-1][j],dp[i][j-w]+v)

one-dimension:
dp[j]=Max/Min(dp[j],dp[j-w]+v)

When it comes to 0-1 knapsack problem,
equation is quite apparent:

1. combination:

two-dimension:
dp[i][j]=dp[i-1][j]+dp[i-1][j-w]

one-dimension:
dp[j]+=dp[j-w]

2. true or false:

two-dimension:
dp[i][j]=dp[i-1][j]||dp[i-1][j-w]

one-dimension:
dp[j]=dp[j]||dp[j-w]

3. max or min:

two-dimension:
dp[i][j]=Max/Min(dp[i-1][j],dp[i-1][j-w]+v)

one-dimension:
dp[j]=Max/Min(dp[j],dp[j-w]+v)

As we can see, one-dimensional state transition equation is the same in 0-1 and complete
And what is the difference?

The essential distinction is the traversal order of the inner layer:

It is reverse order in 0-1 while positive order in complete knapsack problem.
Reasons are fairly understandable:

As in case of complete knapsack, the information of [j-w] is required. 

If it is still difficult to fully understand, then there is a conclusion:

0-1 knapsack problem:

Array outside while the target inside and inner layer is reverse order

Complete knapsack problem:

Array outside while the target inside for combination,
Whichever outside is acceptable for other situations and traversal order is positive

Permutations:

Target outside while array inside