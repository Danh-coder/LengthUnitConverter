# Length Unit Converter

✨ A simple and intuitive Android application for converting between common length units. ✨

This project is a basic length unit converter demonstrating fundamental Android UI design and logic implementation using Java and XML.

## Features

*   **Intuitive UI:** Clean design with clearly labeled inputs and a logical flow.
*   **Input Validation:** Accepts only numeric (decimal) input and handles empty input gracefully.
*   **Unit Selection:** Easily choose "From" and "To" units using standard Android Spinners (dropdowns).
*   **Supported Units:**
    *   Metre
    *   Millimetre
    *   Mile
    *   Foot
*   **Clear Output:** Displays the conversion result prominently.
*   **Centralized Resources:** Uses `strings.xml` for all text elements, simplifying localization and maintenance.

## Design

The application follows a minimalist and functional design:

*   **Layout:** Uses a vertical `LinearLayout` to arrange elements top-to-bottom, ensuring clarity and space.
*   **Input Fields:** An `EditText` for the value with a subtle underline and placeholder text, restricted to decimal input.
*   **Unit Spinners:** Styled as plain text with a right-side arrow, maintaining a clean look without borders or background.
*   **Button:** Centrally positioned with a contrasting color to draw attention.
*   **Result Display:** Shown in a larger font size below the inputs, centered for clear visibility.
*   **Adaptive Text Sizes:** Font sizes utilize Android theme attributes (`?attr/textAppearance...`) for better consistency.

## Installation and Setup

To run this project, you will need Android Studio.

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    ```
    *(Replace `<repository_url>` with the actual URL of your repository)*

2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select "Open an Existing Android Studio Project".
    *   Navigate to the cloned directory and select it.

3.  **Build and Run:**
    *   Android Studio will sync the project.
    *   Connect an Android device or start an AVD (Android Virtual Device) emulator.
    *   Click the "Run" button (green play icon) in the toolbar.
    *   Choose your connected device or emulator to deploy the app.

## Code Overview

The project structure is simple, consisting of three main files:

1.  **`activity_main.xml`**:
    *   Defines the visual structure (layout) of the main activity.
    *   Uses a `LinearLayout` with vertical orientation.
    *   Includes `TextView` for labels, `EditText` for input (restricted to `numberDecimal`), `Spinner` for unit selection, `Button` for conversion, and a `TextView` to display the result.
    *   Elements are spaced using `layout_marginTop` and centered using `layout_gravity`.

2.  **`MainActivity.java`**:
    *   Contains the core logic and event handling for the UI.
    *   Extends `AppCompatActivity`.
    *   Initializes UI elements (`findViewById`).
    *   Uses a `HashMap<String, Double>` (`lengthUnits`) to store unit names and their equivalent values in metres, serving as the basis for conversion.
    *   Sets up the Spinners using an `ArrayAdapter` populated from the `lengthUnits` keys.
    *   Implements an `OnClickListener` for the convert button, which triggers the `convertLength` method.
    *   `convertLength()`:
        *   Retrieves input value and selected units.
        *   Performs basic validation (empty input, valid number format).
        *   Calls the `convert()` method to perform the calculation.
        *   Formats the result using `DecimalFormat` (currently to 4 decimal places).
        *   Displays the formatted result in the `resultTextView`.
    *   `convert(double value, String fromUnit, String toUnit)`:
        *   The core conversion logic.
        *   Converts the input `value` from `fromUnit` to its equivalent in Metres.
        *   Converts the value in Metres to the target `toUnit`.
        *   Returns the final converted value.

3.  **`strings.xml`**:
    *   Centralizes all user-facing text strings (`app_name`, labels, hints, button text).
    *   Includes a `string-array` (`length_units`) holding the names of the supported units, used to populate the Spinners.
    *   Promotes good practice for internationalization and simplifies text updates.

## Future Improvements

Based on the current implementation, potential enhancements include:

*   **Number Formatting:** Implement formatting with commas for large numerical results to improve readability (as noted in the report, using `DecimalFormat` or `NumberFormat.getInstance().format(value)` could achieve this).
*   **Additional Units:** Expand the `lengthUnits` map to include more length units.
*   **Input Clearing:** Add an option or button to clear the input and result fields.
*   **Error Handling:** Provide more specific feedback for different types of invalid input.

## Technologies Used

*   Java
*   Android SDK
*   XML

## Contributing

Contributions are welcome! If you find a bug or have a suggestion, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. *(Note: Create a LICENSE file in the root of your repository if you adopt the MIT license.)*

## Author

*   Danh Phan

---
