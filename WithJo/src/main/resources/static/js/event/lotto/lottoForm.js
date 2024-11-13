
function pageMoveList() {
    location.href = '/lotto/list';
}

function makeLottoNo() {
    $.ajax({
        url: '/lotto/make',
        method: 'POST',
        success: function (data) {
            let htmlStr = '<div id="lottoSelNo">' + data + '</div>';
            $('#lottoSelect').html(htmlStr);
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}

function addLotto() {
    var lottoRound = $('#lottoRound').val().trim();
    var lottoRoundLimit = $('#lottoRoundLimit').val().trim();
    var lottoStartDate = $('#lottoStartDate').val().trim();
    var lottoEndDate = $('#lottoEndDate').val().trim();
    var lottoSelNo = $('#lottoSelNo').text().trim();
	var lotto1st = parseInt($('#lotto1st').val(), 10);
	var lotto2nd = parseInt($('#lotto2nd').val(), 10);
	var lotto3rd = parseInt($('#lotto3rd').val(), 10);
	
    if (!lottoRound || !lottoRoundLimit || !lottoStartDate || !lottoEndDate || !lottoSelNo || !lotto1st || !lotto2nd || !lotto3rd) {
        alert("모든 필드를 입력해주세요.");
        return;
    }
	
    var memberNo = parseInt($('#memberNo').val(), 10);
    var lottoMode = parseInt($('#authority').val(), 10); 

    var lottoData = {
        memberNo: memberNo,
        lottoMode: lottoMode, 
        lottoRound: parseInt(lottoRound, 10),
        lottoRoundLimit: parseInt(lottoRoundLimit, 10),
        lottoStartDate: lottoStartDate,
        lottoEndDate: lottoEndDate,
        lottoSelNo: lottoSelNo,
		lotto1st: lotto1st,
		lotto2nd: lotto2nd,
		lotto3rd: lotto3rd
    };

    $.ajax({
        url: '/lotto/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(lottoData),
        success: function (data) {
            alert("등록이 완료되었습니다");
            window.location.href = "/lotto/list";
        },
        error: function(xhr, status, error) {
            alert('Error: ' + status + ' - ' + error);
        }
    });
}
