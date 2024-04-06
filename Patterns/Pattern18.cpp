#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout<<"Enter the number of rows : ";
    cin>>n;
    
    for(int i=1; i<=n; i++)
    {
        char k = static_cast<char>(65+n-1);
        for(int j=1; j<=i; j++)
        {
            cout<<k<<" ";
            k--;
        }
        cout<<endl;
    }

    return 0;
}