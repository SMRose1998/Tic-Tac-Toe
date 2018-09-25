*** Settings ***
Library          SwingLibrary

*** Keywords ***
Start New Game
    Start Application   edu.jsu.mcis.TicTacToe
    Select Window       Tic-Tac-Toe

Mark Location   [Arguments]     ${row}      ${col}
    ${component}=   Catenate    SEPARATOR=  Square    ${row}  ${col}
    Click On Component  ${component}

Check Location  [Arguments]     ${row}  ${col}  ${mark}
    ${component}=   Catenate    SEPARATOR=  Square    ${row}  ${col}
	${text}=    Get Button Text   ${component}
    Should Be Equal    ${text}    ${mark}
    
Winner Should Be    [Arguments]     ${winner}
	${text}=    Get Label Content    ResultLabel
    Should Be Equal    ${text}    ${winner}
    Close Window    Tic-Tac-Toe
    
*** Test Cases ***
Win Diagonally as X
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       0   1
    Check Location      0   1   O
    Mark Location       0   0
    Check Location      0   0   X
    Mark Location       0   2
    Check Location      0   2   O
    Mark Location       2   2
    Check Location      2   2   X
    Winner Should Be    X

Win Horizontally as O
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       2   0
    Check Location      2   0   O
    Mark Location       0   0
    Check Location      0   0   X
    Mark Location       2   2
    Check Location      2   2   O
    Mark Location       0   2
    Check Location      0   2   X
    Mark Location       2   1
    Check Location      2   1   O
    Winner Should Be    O

Force a Tie
    Start New Game
    Mark Location       1   1
    Check Location      1   1   X
    Mark Location       0   0
    Check Location      0   0   O
    Mark Location       2   0
    Check Location      2   0   X
    Mark Location       0   2
    Check Location      0   2   O
    Mark Location       0   1
    Check Location      0   1   X
    Mark Location       2   1
    Check Location      2   1   O
    Mark Location       1   2
    Check Location      1   2   X
    Mark Location       1   0
    Check Location      1   0   O
    Mark Location       2   2
    Check Location      2   2   X
    Winner Should Be    TIE

    
    