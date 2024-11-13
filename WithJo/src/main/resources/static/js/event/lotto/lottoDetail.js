let globalMatchCount = 0;
let lottoSelNoArray2 = 0;
let eMoney = 0;

// 로또 str 배열 변환
$(document).ready(function() {
    const lottoSelNoStr = $("#lottoSelNoStr").val();
    const lottoSelNoArray = JSON.parse(lottoSelNoStr);

    displayWinningNumbers(lottoSelNoArray);
});

// 랜덤 색깔 적용
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

// 로또 디자인 보이기
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

// 로또 번호 생성
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

// 로또 css 입히기
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

// 맞춘 숫자 반환
function compareLottoNumbers(winningNumbers, userNumbers) {
    return winningNumbers.filter(num => userNumbers.includes(num));
}

// 맞춘 숫자만큼의 등수와 emoney 지정
function displayMatchResult(matchingNumbers) {
    const resultDiv = $("#matchResult");
    const lotto1st = parseInt($('#lotto1st').val(), 10);
    const lotto2nd = parseInt($('#lotto2nd').val(), 10);
    const lotto3rd = parseInt($('#lotto3rd').val(), 10);
    resultDiv.empty();

    globalMatchCount = matchingNumbers.length;

    let resultText;
    if (globalMatchCount >= 3) {
        resultText = "축하합니다! 1등입니다: " + matchingNumbers.join(", ");
		eMoney = lotto1st;
    } else if (globalMatchCount == 2) {
        resultText = "축하합니다! 2등입니다: " + matchingNumbers.join(", ");
		eMoney = lotto2nd;
    } else if (globalMatchCount == 1) {
        resultText = "축하합니다! 3등입니다: " + matchingNumbers.join(", ");
		eMoney = lotto3rd;
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
	
	if(eMoney > 0) {
		insertMemberEMoney(eMoney)
	};
}

// emoney 지급
function insertMemberEMoney(eMoney){
	var emoneyData = {
		eMoney: eMoney,
		memberNo: parseInt($("#memberNo").val(), 10),
		round: parseInt($('#lottoRound').val(), 10)
	};
	$.ajax({
	    url: '/lotto/emoney',
	    method: 'POST',
	    contentType: 'application/json',
	    data: JSON.stringify(emoneyData),
	    success: function (data) {
			eMoney = 0;
	    },
	    error: function(xhr, status, error) {
	        alert('1Error: ' + status + ' - ' + error);
	    }
	});
	
}

// 유저가 뽑은 로또 인서트
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
            alert('2Error: ' + status + ' - ' + error);
        }
    });
}

// 유저의 추첨횟수가 남았는지 체크
function memberCountCheck() {
    var lottoData = {
        memberNo: parseInt($('#memberNo').val(), 10),
        lottoRound: parseInt($('#lottoRound').val(), 10),
        lottoRoundLimit: parseInt($('#lottoRoundLimit').val(), 10),
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
            alert('3Error: ' + status + ' - ' + error);
        }
    });
}

function pageMoveLottoList() {
	location.href = '/lotto/list';
}

function pageMoveEventList() {
	location.href = '/event/list';
}