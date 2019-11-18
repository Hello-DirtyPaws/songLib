# README #

# Title and Project Info #
Designed a song library (SongLib) (java application) which allows users to add/delete/edit songs(data) using JavaFX

# Requirements #
Design and implement an application with a graphical user interface to manage a library of songs. A song is uniquely identified by a combination of name and artist (case INsensitive). Your application should have a SINGLE WINDOW with three functions:

Song list display, with the ability to select ONE song from the list.
The list will display the name and artist ONLY for each song, in alphabetical order of names (and within duplicate names, by alphabetical order of artists). Unless the list is empty, one song is always pre-selected, and its details shown - see the following item.

Song detail, with name, artist, album, and year, of the song that is selected in the song list interface
Song Add/Delete/Edit, for adding a new song, deleting a selected song, and editing a selected song:
Add: When a new song is added, the song name and artist should be entered at the very least. Year and album are optional. If the name and artist are the same as an existing song, the add should not be allowed - a message should be shown in a pop-up dialog, or by some other means within the main application window.
The newly added song should automatically be placed in the correct position in the alphabetical order in the list. Also, it should be automatically selected, replacing the previously selected song, and its details should be shown.

Edit: ANY of the fields can be changed. Again, if name and artist conflict with those of an existing song, the edit should NOT be allowed - a message should be shown in a pop-up dialog, or by some other means within the main application window.
Delete: Only the selected song in the list can be deleted. After deletion, the next song in the list should be selected, and the details displayed. If there is no next song, the previous song should be selected, and if there is no previous song either, then the list is empty and the detail info is all blanks.
For any of the add/delete/edit actions, the user should be able to cancel (or back out of) the action if they change their mind after starting the action.

Note: If you use the song detail display area for add/delete/edit as well (instead of two separate areas), then make sure the interface is not confusing to the user, particularly if the add or edit is disallowed or aborted by the user.

When your program is started, it should show the current list of songs in the library, in the song list display, with the first song selected by default. (The first time the program is run, there should be nothing in the display, since there won't be any songs in the library.)

The song library data should persist across different sessions of your program. You can save the song list in a file in whatever TEXT (human readable) format you like, and then read it into your program when it starts up. (This means you may not serialize the data, even if you know how to do it, because serialized data is not human readable.)

Your application is NOT required to play a song when it is selected. In other words, there is no requirement to have audio playing functionality, and there will not be any extra credit if you choose to implement this functionality.

The application window need NOT be resizable. When the window is closed, the application should be terminated.

