//id중복확인 기능 + 유효성
// 중복이거나 4~20글자아 아니면 input태그 밑에 문구로 안내

// 회원가입 후 메인페이지(도서 목록 페이지)로 이동


//회원가입
const regMem = () => {
  const result = confirm('회원가입을 진행합니다.')
  isValidData();
  if(isValidData()){
    console.log('회원가입 실행');
    document.querySelector('form').submit();
  }
}

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
const checkDuplicate = () => {
  //입력한 id
  const memId = document.querySelector('#memId').value;

  //id입력 여부 확인
  if(memId === ''){
    set_id_p('invalid', 'ID를 입력하지 않았습니다.');
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
      set_id_p('valid', '사용 가능한 ID입니다.')
    }
  })
  .catch((error) => {
    console.log('ID 중복체크 중 오류!');
    console.log(error);
  });


}


//유효성 검사
// 회원가입 유효성 검사 기능 추가

// 4) 연락처 유효성
// 위 유효성 검사가 맞지 않으면 input 태그 아래 문구를 추가해서 안내
const isValidData = () => {
  let data = true;
  //모든 정보 필수 입력(주소 제외)
  const memId = document.querySelector('#memId').value;
  const memPw = document.querySelector('#memPw').value;
  const reMemPw = document.querySelector('#reMemPw').value;
  const tel1 = document.querySelector('#tel1').value;
  const tel2 = document.querySelector('#tel2').value;
  const tel3 = document.querySelector('#tel3').value;
  const memAddr = document.querySelector('#memAddr').value;
  const addrDetail = document.querySelector('#addrDetail').value;
  const gender = document.querySelector('input[name="gender"]:checked').value;
  

  // 1) 주소를 제외한 모든 정보는 필수 입력 (다음 주소록 api)
  if(memId === ''|| memPw === '' || reMemPw == '' || tel2 === '' || tel3 === '' || gender === ''){
    alert('미입력 정보가 있습니다. (주소 제외)');
    data = false;
  }

  // 2) id는 4~20글자
  const idRegex = /^.{6,20}$/;
  if(!idRegex.test(memId)){
    data = false;
  }
  
  // 3) 비번은 6~20글자 숫자+영문 조합만 가능
  const pwRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$/;
  if(!pwRegex.test(memPw)){
    data = false;
  }

  // 5) 비번 일치
  if(memPw !== reMemPw){
    data = false;
  }

  return data;
}