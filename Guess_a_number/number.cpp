#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{

    int number1;
    int number2;

    number1 = rand() % 10000;

    cout << "Guess the number (-1 to stop): ";
    cin >> number2;

    while (number2 != -1)
    {
        if (number2 != number1)
        {
            if (number1 > number2)
                cout << "Incorrect. The number is higher. Try again!" << endl;
            else if (number1 < number2)
                cout << "Incorrect. The number is smaller. Try again!" << endl;
        }
        else
        {
            cout << "Correct!" << endl;
            number1 = rand() % 100;
            cout << "Guess a new number!" << endl;
        }

        cout << "Guess the number (-1 to stop): ";
        cin >> number2;
    }

    return 0;
}