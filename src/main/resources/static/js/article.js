// 등록 버튼 이벤트 기능
var createBtn = document.getElementById('create-btn');

if (createBtn) {
    createBtn.addEventListener('click', evt => {
        fetch('/api/articles', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title1').value,
                content: document.getElementById('content1').value
            })
        }).then(date => {
            alert('등록완료');
            location.replace('/articles'); //articles 페이지로 이동
        })
    })
}