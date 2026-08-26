//id중복확인 기능 + 유효성
// 중복이거나 4~20글자아 아니면 input태그 밑에 문구로 안내

// 회원가입 후 메인페이지(도서 목록 페이지)로 이동

//id 중복검사  결과 p태그 디자인 변경하는 함수
const set_id_p = (result, msg) => {
  //p태그 선택
  const id_p = document.querySelector('#id_p');
  
  id_p.textContent = msg;

  //유효한 결과
  if(result === 'valid'){
    id_p.classList.remove('invalid');
    id_p.classList.add('valid');
  }
  else{//'invalid'
    id_p.classList.remove('valid');
    id_p.classList.add('invalid');
  }
}

//id중복확인 기능 + 유효성
//중복검사 버튼 클릭 시 실행 함수
const checkDuplicate = () => {
  //입력한 id
  const memId = document.querySelector('#join-modal input[name="memId"]').value;
  
  // 2) id는 4~20글자 유효성 검사 실패 시
  const idRegex = /^[A-Za-z0-9]{4,20}$/;

  //id입력 여부 확인
  if(!idRegex.test(memId)){
    set_id_p('invalid', 'ID는 4~20글자 영문, 숫자만 가능합니다.');
    return;
  }

  axios
  .get(`/member/check-id?memId=${memId}`)
  .then((response) => {
    // alert(response.data);
    //중복이면 p태그 삽입!
    if(response.data){
      set_id_p('invalid', '중복ID 입니다.');
      return;
    }
    else{
      set_id_p('valid', '사용 가능한 ID입니다.');
      //회원가입 버튼 활성화(discableed 속성 제거)
      const join_btn = document.querySelector('#join-btn');
      join_btn.removeAttribute('disabled');
    }
  })
  .catch((error) => {
    console.log('ID 중복체크 중 오류!');
    console.log(error);
  });


}

//회원가입 모달창에서 id 변경 시 실행되는 함수
const addDisabled = () => {
 document.querySelector('#join-btn').setAttribute('disabled', '');
 
 //id 유효성 검사 p태그도 초기화
  document.querySelector('#id_p').textContent = '';
}


// 4) 연락처 유효성
// 위 유효성 검사가 맞지 않으면 input 태그 아래 문구를 추가해서 안내
const joinValidData = () => {
  //유효성 검사 결과 저장 변수
  let result = true;
  //모든 정보 필수 입력(주소 제외)
  const memPw = document.querySelector('#join-modal input[name="memPw"]' ).value;
  const reMemPw = document.querySelector('#reMemPw').value;
  const memName = document.querySelector('#join-modal input[name="memName"]').value;
  const tel1 = document.querySelector('#join-modal input[name="memTel1"]').value;
  const tel2 = document.querySelector('#join-modal input[name="memTel2"]').value;
  const tel3 = document.querySelector('#join-modal input[name="memTel3"]').value;

  //완성된 연락처
  const memTel = `${tel1}-${tel2}-${tel3}`;

  // 3) 비번은 6~20글자 숫자+영문 조합만 가능 유효성 검사 실패 시
  const pwRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$/;
  if(!pwRegex.test(memPw)){
    document.querySelector('#pw_p').textContent = '6~20글자, 영문+숫자 조합만 가능합니다.';
  }

  // 5) 입력한 두 비번 일치 실패 시
  if(memPw !== reMemPw){
    document.querySelector('#pw_p').textContent = '입력한 비밀번호가 일치하지 않습니다.'; 
  }

  //이름 유효성 검사 실패 시
  const nameRegex = /^[가-힣]{2,10}$/;
  if(!nameRegex.test(memName)){
    document.querySelector('#name_p').textContent = '2~10글자, 한글만 가능합니다.'; 
  }

  //연락처 정규식 유효성 검사 실패 시
  const telRegex = /^01[016789]-?\d{3,4}-?\d{4}$/;
  if(!telRegex.test(memTel)){
    document.querySelector('#tel_p').textContent = '연락처 정보가 정확하지 않습니다.'; 
  }

  return result;
}

//회원가입 버튼 클릭 시 실행함수
//유효성 검사 및 회원가입 요청 
//유효성 검사 성공 시 리턴 ture;
const join = () => {
  //유효성 검사
  const validate_result = joinValidData();
  console.log(validate_result);
  if(validate_result){
    console.log('회원가입 실행');
    alert('회원가입 완료!');
    //submit
    document.querySelector('#join-form').submit();
  }
}

// const searchPostCode1 = () => {
//   new kakao.Postcode({
//     oncomplete: function(data) {
//       //주소를 선택하면 주소 input태그에 선택한 주소 정보를 들어가야 한다.
//      document.querySelector('#memAddr').value = data.roadAddress;
//     }
//   }).open();
// }

const searchPostCode = () => {
   new kakao.Postcode({
    oncomplete: function(data) {
      //주소값을 data에 저장한다.
      document.querySelector('input[name="memAddr"]').value = data.roadAddress; 
    }
   }).open();
}

//로그인 기능! 비동기-> header oo님 반갑습니다. 띄우기!!!
const login = () => {
  //아아디, 비밀번호
  const memId = document.querySelector('.modal-content input[name="memId"]').value;
  const memPw = document.querySelector('.modal-content input[name="memPw"]').value;
  
  //로그인 버튼을 누르면 id, 비밀번호 일치여부를 확인! (비동기)
  // axios
  // .post('/member/login', {memId:memId, memPw:memPw})
  // .then((response) => {
  //   console.log(response.data);
  // })
  // .catch((error) => {
  //   console.log('로그인 실패!');
  //   console.log(error);
  // });

  //로그인 버튼 누르면 동기 실행 함수 로그인 정보를 가지고 확인 먼저 한다!
  check();
  const login_btn = document.querySelector('#login-btn');

  if(check){
    document.querySelector('form').submit();
  }

}


//아이디 비밀번호 입력이 된 후 
const check = () => {
  let result = true;
  //아아디, 비밀번호
  const memId = document.querySelector('.modal-content input[name="memId"]').value;
  const memPw = document.querySelector('.modal-content input[name="memPw"]').value;
  
  if(memId === ''){
    document.querySelector('#name_p').textContent = '아이디를 입력하세요.'
    result = false;
  }
  if(memPw === ''){
    document.querySelector('#pw_p').textContent = '비밀번호를 입력하세요.'
    result = false;
  }
  return result;
}

