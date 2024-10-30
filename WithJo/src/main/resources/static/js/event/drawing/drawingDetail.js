let globalMatchCount = 0;
let lottoSelNoArray2 = 0;

$(document).ready(function() {
    const lottoSelNoStr = $("#lottoSelNoStr").val();
    const lottoSelNoArray = JSON.parse(lottoSelNoStr);

    displayWinningNumbers(lottoSelNoArray);
});

function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function displayWinningNumbers(numbers) {
    const winningLottoSelNoDiv = $("#winningLottoSelNo");
    winningLottoSelNoDiv.empty();

    numbers.forEach(num => {
        const numDiv = $("<div>")
            .addClass("lottoNumber")
            .text(num)
            .css("backgroundColor", getRandomColor());
        winningLottoSelNoDiv.append(numDiv);
    });
}

function makeLottoNo() {
    $.ajax({
        url: '/lotto/make',
        method: 'POST',
        success: function (data) {
            let memberSelNo = data;
            let memberSelNoArray = Array.isArray(memberSelNo) ? memberSelNo : JSON.parse(memberSelNo);
            
            memberSelNoArray.sort((a, b) => a - b);
            lottoSelNoArray2 = memberSelNoArray;
            
            displayMemberNumbers(memberSelNoArray);
            const matchingNumbers = compareLottoNumbers(JSON.parse($("#lottoSelNoStr").val()), memberSelNoArray);
            displayMatchResult(matchingNumbers);
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function displayMemberNumbers(numbers) {
    const memberLottoSelNoDiv = $("#memberLottoSelNo");
    memberLottoSelNoDiv.empty();

    numbers.forEach(num => {
        const numDiv = $("<div>")
            .addClass("lottoNumber")
            .text(num)
            .css("backgroundColor", getRandomColor());
        memberLottoSelNoDiv.append(numDiv);
    });
}

function compareLottoNumbers(winningNumbers, userNumbers) {
    return winningNumbers.filter(num => userNumbers.includes(num));
}

function displayMatchResult(matchingNumbers) {
    const resultDiv = $("#matchResult");
    resultDiv.empty();

    globalMatchCount = matchingNumbers.length;

    let resultText;
    if (globalMatchCount > 3) {
        resultText = "축하합니다! 1등입니다: " + matchingNumbers.join(", ");
    } else if (globalMatchCount == 2) {
        resultText = "축하합니다! 2등입니다: " + matchingNumbers.join(", ");
    } else if (globalMatchCount == 1) {
        resultText = "축하합니다! 3등입니다: " + matchingNumbers.join(", ");
    } else {
        resultText = "아쉽지만 다음기회에~";
    }

    resultDiv.text(resultText)
        .css({
            "fontSize": "24px",
            "fontWeight": "bold",
            "marginTop": "20px",
            "textAlign": "center"
        });
    
    insertMemberLotto();
}

function insertMemberLotto() {
    var lottoData = {
        memberNo: parseInt($('#memberNo').val(), 10),
        lottoMode: parseInt($('#authority').val(), 10),
        lottoRound: parseInt($('#lottoRound').val(), 10),
        lottoSelNo: JSON.stringify(lottoSelNoArray2),
        lottoWinning: globalMatchCount
    };

    $.ajax({
        url: '/lotto/add2',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(lottoData),
        success: function (data) {
            alert("추첨이 완료되었습니다");
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function memberCountCheck() {
    var lottoData = {
        memberNo: parseInt($('#memberNo').val(), 10),
        lottoRound: parseInt($('#lottoRound').val(), 10),
    };

    $.ajax({
        url: '/lotto/check',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(lottoData),
        success: function (data) {
            var count = parseInt(data.lottoCount, 10);
            if (count == 1) {
                alert("횟수를 모두 소진하셨습니다.");
            } else if (count == 0) {
                makeLottoNo();
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function pageMoveLottoList() {
	location.href = '/lotto/list';
}

function pageMoveEventList() {
	location.href = '/event/list';
}