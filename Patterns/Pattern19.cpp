#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout<<"Enter the value of n : ";
    cin>>n;
    
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=n-i+1; j++)
        {
            cout<<"*";
        }
        for(int k=1; k<=2*n-2*(n-i+1); k++)
        {
            cout<<" ";
        }
        for(int m=1; m<=n-i+1; m++)
        {
            cout<<"*";
        }
        cout<<endl;
    }
    for(int i=1; i<=n; i++)
    {
        for(int j=1; j<=i; j++)
        {
            cout<<"*";
        }
        for(int k=1; k<=2*(n-i); k++)
        {
            cout<<" ";
        }
        for(int m=1; m<=i; m++)
        {
            cout<<"*";
        }
        cout<<endl;
    }

    return 0;
}