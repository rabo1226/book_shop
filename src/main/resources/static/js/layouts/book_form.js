const regBook = () => {
  
  const check = confirm('도서 등록을 진행할까요?');
  if(check){
    const result = bookCheck();

    if(result){
      console.log('도서등록');
      document.querySelector('form').submit();
    }
  }  
}

const bookCheck = () => {
  let data = true;
  const bookName = document.querySelector('input[name="bookName"]').value;
  const author = document.querySelector('input[name="author"]').value;

  const bookNameRegex = /^.{2,}$/;
  const authorRegex = /^.{2,}$/;
  
  //도서명(최소 2글자)
  if(!bookNameRegex.test(bookName)){
    document.querySelector('#book-p').textContent = '도서명은 2글자 이상 입력해야 합니다.'
    data = false;
  }
  //저자(최소 2글자)
  if(!authorRegex.test(author)){
    document.querySelector('#author-p').textContent = '저자는 2글자 이상 입력해야 합니다.'
    data = false;
  }

  return data;
}