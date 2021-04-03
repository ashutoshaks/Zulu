#include <bits/stdc++.h>
using namespace std;

int main()
{
    for (int i = 1; i <= 30; i++)
    {
        cout << "INSERT INTO `sales` (`sale_date`, `total_amount`) VALUES (\'2021-04-" << i << "\', " << rand() % 50 << ");\n";
    }
}