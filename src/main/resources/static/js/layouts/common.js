// 모달 관련 함수
//모달창 오픈(active클래스 추가)
const openModal = (modal_id) => {
  const modal_tag = document.querySelector(modal_id); 
  modal_tag.classList.add('active');
}

//모달창 오픈(active클래스 삭제)
const closeModal = (modal_id) => {
   const modal_tag = document.querySelector(modal_id); 
   modal_tag.classList.remove('active');
}