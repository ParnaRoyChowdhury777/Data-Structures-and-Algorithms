#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout<<"Enter the number of rows : ";
    cin>>n;
    
    for(int i=1; i<=n; i++)
    {
        char k = 'A';
        for(int j=1; j<=i; j++)
        {
            cout<<k<<" ";
            k++;
        }
        cout<<endl;
    }

    return 0;
}