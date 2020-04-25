#include <iostream>
#include <string>
#include <stdlib.h>

using namespace std;

enum TempLevel {
  Low = 15, Medium = 30, High = 45
};

enum TempConverter {
  Celsius = 1, Fahrenheit
};

void TempLevel(int convertedValue);

int main()

{

  while (true)

  {

    TempConverter Converter;

    int userInput, choice, convertedValue;

    cout << "----------------------------------" << endl;

    cout << "Please enter the choice : " << endl;

    cout << "Enter " << Celsius << " -- convert from Celsius to Fahrenheit" << endl;

    cout << "Enter " << Fahrenheit << " -- convert from Fahrenheit to Celsius" << endl;

    cout << "Choice :";

    cin >> choice;

    switch (choice)

    {

    case Celsius:

      cout << "Please enter the Celsius value : ";

      cin >> userInput;

      convertedValue = (userInput * 9 / 5) + 32;

      cout << "Fahrenheit is " << convertedValue << endl;

      TempLevel(userInput);

      break;

    case Fahrenheit:

      cout << "Please enter the Fahrenheit value : ";

      cin >> userInput;

      convertedValue = (userInput - 32) * 5 / 9;

      cout << "Celsius is " << convertedValue << endl;

      TempLevel(convertedValue);

      break;

    default:

      cout << "Invalid Option" << endl;

      exit(0);

      break;

    }

  }

}

void TempLevel(int convertedValue)

{

  string result;

  convertedValue <= Low ? result = "Temperature is cold" : "";

  convertedValue > Low && convertedValue <= Medium ? result = "Temperature is comfort" : "";

  convertedValue > Medium && convertedValue <= High ? result = "Temperature is hot" : "";

  convertedValue > High ? result = "Temperature is very hot" : "";

  cout << result << endl;

}
