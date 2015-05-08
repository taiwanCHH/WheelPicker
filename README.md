WheelPicker
============

WheelPicker is a library to provides a dialog fragment to pick two string value.





## Sample

Please try to move the [sample module](https://github.com/hotchemi/StringPicker/tree/master/sample/).

## How to use

### WheelPickerDialog

implements in your activity.

```java
StringPickerDialog dialog = new StringPickerDialog();
Bundle bundle = new Bundle();
List first;
Hasp second;
bundle.putParcelable(getString(R.string.string_picker_dialog_values), new DataModel(first,second));
dialog.setArguments(bundle);
dialog.show(getSupportFragmentManager(), TAG);
```

callback.

```java
@Override
public void onClick(String pickerOneValue, String pickerTwoValue) {
        mTextView.setText(pickerOneValue + pickerTwoValue);
}
```

### Custom dialog

If you want to use your own dialog labels, override string xml resources on your application.

```xml
<resources>
    <string name="string_picker_dialog_values">STRING_PICKER_DIALOG_VALUES</string>
    <string name="string_picker_dialog_title">StringPickerDialog</string>
    <string name="string_picker_dialog_ok">OK</string>
    <string name="string_picker_dialog_cancel">Cancel</string>
</resources>
```

## Requirements

Supports Android 4.0 or greater.

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

## License

```
Copyright 2014 taiwanCHH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
