//유효성 검사 성공 시 return = true;
const bookCheck = () => {
  let data = true;
  const bookName = document.querySelector('input[name="bookName"]').value;
  const author = document.querySelector('input[name="author"]').value;
  const bookPrice = document.querySelector('input[name="bookPrice"]').value;
  const stock = document.querySelector('input[name="stock"]').value;
  const bookInfo = document.querySelector('textarea[name="bookInfo"]').value;
  const category = document.querySelector('select[name="categoryNo"]').value;

  const bookNameRegex = /^.{2,30}$/;
  const authorRegex = /^.{2,20}$/;
  const priceRegex = /^[1-9]\d*$/;
  const stockRegex = /^[1-9]\d*$/;
  const introRegex = /^.{1,100}$/;
  
  //도서명(최소 2글자)
  if(!bookNameRegex.test(bookName)){
    document.querySelector('#book-p').textContent = '도서명이 올바르지 않습니다.';
    data = false;
  }
  //저자(최소 2글자)
  if(!authorRegex.test(author)){
    document.querySelector('#author-p').textContent = '저자는 2~20 글자 입력해야 합니다.';
    data = false;
  }
  //가격 : 필수입력, 양수만 가능
   if(!priceRegex.test(bookPrice)){
    document.querySelector('#price-p').textContent = '필수입력입니다.';
    data = false;
   }

  //재고 : 필수입력, 양수만 가능
  if(!stockRegex.test(stock)){
    document.querySelector('#stok-p').textContent = '필수입력입니다.';
    data = false;
  }
  //책 소개 : 필수입력, 최대 100글자
  if(!introRegex.test(bookInfo)){
    document.querySelector('#bookInfo-p').textContent = '도서소개는 필수입력입니다.';
    data = false;
  }

  //카테고리 필수 선택
  if(category === ''){
    document.querySelector('#category-p').textContent = '카테고리를 선택하세요.';
    data = false;
  }

  return data;
}

//도서 등록 버튼 클릭 시 실행함수
const regBook = () => {
  
  const check = confirm('도서 등록을 진행할까요?');
  if(check){
    const result = bookCheck();

    if(result){
      console.log('도서등록');
      document.querySelector('#book-form').submit();
    }
  }  
}

//카테고리 등록 버튼 클릭 시 실행함수
const regCategory = () => {
  const cName = document.querySelector('input[name="categoryName"]').value;

  //2글자 이상
  const categoryNameRegex = /^.{2,30}$/;
  if(categoryNameRegex.test(cName)){
    //alert('카테고리를 등록합니다.');
    document.querySelector('#reg-category').submit();
  }
}