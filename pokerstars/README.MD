##to install necessities

sudo apt update
sudo apt install wine

##to download the .exe

https://www.pokerstars.eu/poker/download/

##to work around the pokerstars OS detection

They're probably trying to be clever with OS detection and it's not working very well. Right-click the Windows download link and click "Copy Link Location". Open Applications->Accessories->Terminal. Run


##winkwink

https://www.pokerstars.eu/poker/client/download/

Code:

wget [Ctrl+Shift+v]

When it's done, the file will be something like download_...=.cgi. Rename it to PokerStarsInstall.exe then run with Wine. 

https://ubuntuforums.org/showthread.php?t=1527140

##to install the app

wine PokerStarsInstaller.exe

##to run 

wine "C:\Program Files (x86)\PokerStars\PokerStars.exe"
