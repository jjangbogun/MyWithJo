function lottoHide() {
    var eventLottoVal = $('#lottoVal').val() === '1' ? '0' : '1';

    var hideData = {
        eventLotto: eventLottoVal
    };

    $.ajax({
        url: '/event/update1',  
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(hideData),  
        success: function (data) {
            console.log('처리 성공:', data);
            location.reload();  
        },
        error: function(xhr, status, error) {
            console.error('Error:', error); 
            alert('처리 실패: ' + status + ' - ' + error);
        }
    });

}


function drawingHide() {
    var eventDrawingVal = $('#drawingVal').val() === '1' ? '0' : '1'; 

    var hideData = {
        eventDrawing: eventDrawingVal
    };

    $.ajax({
        url: '/event/update2',  
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(hideData),  
        success: function (data) {
            console.log('처리 성공:', data);
            location.reload();  
        },
        error: function(xhr, status, error) {
            console.error('Error:', error); 
            alert('처리 실패: ' + status + ' - ' + error);
        }
    });
}