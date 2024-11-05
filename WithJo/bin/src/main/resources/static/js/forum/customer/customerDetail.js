// customerDetail.js

function deleteFnc() {        
    if(confirm("해당 질문을 삭제 하시겠습니까?")) {            
        var form = document.getElementById("commonForm");
        form.action = '/customer/delete';
        form.method = 'POST';
        form.submit();            
    } else {        
        alert("질문삭제가 취소 되었습니다!");            
    }
}

function pageMoveAnswer() {
    const customerNo = window.customerNo;
    location.href = '/customer/update?customerNo=' + customerNo;
}

function pageMoveList() {
    location.href = '/customer/list';
}

$(document).ready(function() {
    let customerQue = $('#customerQue').val();
    customerQue = customerQue.replaceAll("\n", "<br/>");
    $('#divcustomerQue').html(customerQue);
    
    let customerAns = $('#customerAns').val();
    customerAns = customerAns.replaceAll("\n", "<br/>");
    $('#divcustomerAns').html(customerAns);
});