// 모달 관련 함수
//모달창 오픈(active클래스 추가)
const openModal = (modal_id) => {
  const modal_tag = document.querySelector(modal_id); 
  modal_tag.classList.add('active');
}

//모달창 닫기(active클래스 삭제)
const closeModal = (modal_id) => {
  const modal_tag = document.querySelector(modal_id); 
  modal_tag.classList.remove('active');

  //모달창 안의 폼 요소 초기화
  //모달창 안의 form 태그가 있을 떄만 실행.
  const form_tag = modal_tag.querySelector('form');
  // console.log(form_tag);
  if(form_tag !== null){
    form_tag.reset();
  }
  
  //id 유효성 검사 p태그도 초기화
  //All은 배열이므로 반복문으로 접근이 필요하다.
  const pTags = document.querySelectorAll('.validate-p');
  for(const pTag of pTags){
    pTag.textContent = '';
  }


}