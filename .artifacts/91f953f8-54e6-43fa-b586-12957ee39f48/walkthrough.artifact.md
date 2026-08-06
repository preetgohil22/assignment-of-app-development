# Walkthrough - Image Slider Fixes

I have fixed the image slider by resolving the ID mismatch between the layout and the code, aligning the button logic with the icons, and ensuring the images overlap correctly.

## Changes Made

### 1. Corrected ID References
- **Issue**: The code was looking for `pic0`, `pic1`, `pic2`, but the XML defined them as `pic1`, `pic2`, `pic3`.
- **Fix**: Updated `MainActivity.kt` to use `"pic${currentimage + 1}"`, so it correctly finds the `ImageView`s.

### 2. Centered Images in Layout
- **Issue**: The images were not constrained to the center, so they didn't overlap perfectly for the alpha transition.
- **Fix**: Added start, end, top, and bottom constraints to `pic1`, `pic2`, and `pic3` in `activity_main.xml`.

### 3. Aligned Button Logic with Icons
- **Issue**: `btn1` (Fast Forward) was assigned to the "Previous" action, and `btn2` (Rewind) was assigned to "Next".
- **Fix**: Swapped the button assignments in `MainActivity.kt` so `btn1` (FF) moves forward and `btn2` (Rewind) moves backward.

### 4. Set Initial State
- **Fix**: Added `textview.text = name[currentimage]` in `onCreate` so the first name ("SHIVA") is visible as soon as the app starts.

## Verification Results

> [!NOTE]
> The image slider now correctly transitions between images and updates the corresponding name when clicking the buttons.

- [x] **Initial State**: Shows the first image and the text "SHIVA".
- [x] **Next Button (FF)**: Transitions from `pic1` -> `pic2` -> `pic3` -> `pic1` and updates text.
- [x] **Previous Button (Rewind)**: Transitions from `pic1` -> `pic3` -> `pic2` -> `pic1` and updates text.
- [x] **Overlap**: Images stay centered in their container during transitions.

render_diffs(file:///C:/Users/Preet%20Gohil/OneDrive/Desktop/imageslide/app/src/main/res/layout/activity_main.xml)
render_diffs(file:///C:/Users/Preet%20Gohil/OneDrive/Desktop/imageslide/app/src/main/java/com/example/imageslide/MainActivity.kt)
