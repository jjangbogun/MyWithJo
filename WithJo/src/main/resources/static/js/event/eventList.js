function lottoHide() {
    var eventHideVal = 0;

    var hideData = {
        eventHideShow: eventHideVal
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

function lottoShow() {
    var eventHideVal = 1;

    var hideData = {
        eventHideShow: eventHideVal
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
    var eventDrawingHide = 0; 

    var hideData = {
        eventHideShow: eventDrawingHide
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

function drawingShow() {
    var eventDrawingHide = 1; 

    var hideData = {
        eventHideShow: eventDrawingHide
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