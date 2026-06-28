#include <iostream>
using namespace std;

int main (){

    double variable1;
    double variable2;
    char operation;

    cout << "Enter your operation with a space in between: ";
    cin >> variable1 >> operation >> variable2;

    switch(operation)
    {
        case '+':
            cout << variable1 + variable2 << endl;
            break;
        case '-' :
            cout << variable1 - variable2 << endl;
            break;
        case '*':
            cout << variable1 * variable2 << endl;
            break;
        case '/':
            cout << variable1 / variable2 << endl;
            break;
        default:
            cout << "ERROR: Unknown operator" << endl;
    }


 return 0;

}
