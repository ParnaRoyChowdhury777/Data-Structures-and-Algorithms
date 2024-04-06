#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout<<"Enter the number of rows : ";
    cin>>n;

    for(int i=1; i<=n ;i++)
    {
        for(int k=1; k<=i-1; k++)
        {
            cout<<" ";
        }

        for(int j=1; j<=2*(n-i)+1; j++)
        {
            cout<<"*";
        }

        cout<<endl;
    }
    return 0;
}