## 의약품 제품 허가 정보

### 목록

| name             | type   | description |
|------------------|--------|-------------|
| BIZRNO           | string | 사업자등록번호     |
| ITEM_SEQ         | string | 품목기준코드      |
| ITEM_NAME        | string | 품목명         |
| ITEM_ENG_NAME    | string | 영문제품명       |
| ENTP_NAME        | string | 업체명         |
| ENTP_ENG_NAME    | string | 영문업체명       |
| ENTP_SEQ         | string | 업일련번호       |
| ENTP_NO          | string | 업허가번호       |
| ITEM_PERMIT_DATE | string | 품목허가일자      |
| INDUTY           | string | 업종          |
| PRDLST_STDR_CODE | string | 품목일련번호      |
| SPCLTY_PBLC      | string | 전문/일반구분     |
| PRDUCT_TYPE      | string | 분류명         |
| PRDUCT_PRMISN_NO | string | 품목허가번호      |
| ITEM_INGR_NAME   | string | 주성분         |
| ITEM_INGR_CNT    | string | 주성분수        |
| BIG_PRDT_IMG_URL | string | 큰제품이미지      |
| PERMIT_KIND_CODE | string | 신고/허가구분     |
| CANCEL_DATE      | string | 취하일자        |
| CANCEL_NAME      | string | 취하구분        |
| EDI_CODE         | string | 보험코드        |

### 상세

| name               | type   | description     |
|--------------------|--------|-----------------|
| ITEM_SEQ           | string | 품목기준코드          |
| ITEM_NAME          | string | 품목명             |
| ENTP_NAME          | string | 업체명             |
| ITEM_PERMIT_DATE   | string | 허가일자            |
| CNSGN_MANUF        | string | 위탁제조업체          |
| ETC_OTC_CODE       | string | 전문일반            |
| CHART              | string | 성상              |
| BAR_CODE           | string | 표준코드            |
| MATERIAL_NAME      | string | 원료성분            |
| EE_DOC_ID          | string | 효능효과 ID         |
| UD_DOC_ID          | string | 용법용량 ID         |
| NB_DOC_ID          | string | 주의사항 ID         |
| INSERT_FILE        | string | 첨부문서            |
| STORAGE_METHOD     | string | 저장방법            |
| VALID_TERM         | string | 유효기간            |
| REEXAM_TARGET      | string | 재심사대상           |
| REEXAM_DATE        | string | 재심사기간           |
| PACK_UNIT          | string | 포장단위            |
| EDI_CODE           | string | 보험코드            |
| PERMIT_KIND_NAME   | string | 허가/신고구분         |
| ENTP_NO            | string | 업체허가번호          |
| MAKE_MATERIAL_FLAG | string | 완제/원료구분         |
| NEWDRUG_CLASS_NAME | string | 신약              |
| INDUTY_TYPE        | string | 업종구분            |
| CANCEL_DATE        | string | 취소일자            |
| CANCEL_NAME        | string | 상태              |
| CHANGE_DATE        | string | 변경일자            |
| NARCOTIC_KIND_CODE | string | 마약종류코드          |
| GBN_NAME           | string | 변경이력            |
| TOTAL_CONTENT      | string | 총량              |
| EE_DOC_DATA        | string | 효능효과 문서 데이터     |
| UD_DOC_DATA        | string | 용법용량 문서 데이터     |
| NB_DOC_DATA        | string | 주의사항(일반) 문서 데이터 |
| PN_DOC_DATA        | string | 주의사항(전문) 문서 데이터 |
| MAIN_ITEM_INGR     | string | 유효성분            |
| INGR_NAME          | string | 첨가제             |
| ATC_CODE           | string | ATC코드           |
| ITEM_ENG_NAME      | string | 품목영문명           |
| ENTP_ENG_NAME      | string | 업체영문명           |
| MAIN_INGR_ENG      | string | 주성분영문명          |
| BIZRNO             | string | 사업자등록번호         |
| RARE_DRUG_YN       | string | 희귀의약품여부         |

## 묶음 의약품 정보

| name                  | type   | description |
|-----------------------|--------|-------------|
| trustIndutyCode       | string | 대표 품목기준코드   |
| trustItemName         | string | 대표 제품명      |
| trustMainingr         | string | 대표 주성분      |
| trustQntList          | string | 대표 함량       |
| trustEntpName         | string | 대표 업소명      |
| trustManuf            | string | 대표 제조소      |
| trustItemPermitDate   | string | 대표 허가일자     |
| trustHiraMainingrCode | string | 대표 심평원주성분코드 |
| trustHiraPrductCode   | string | 대표 심평원제품코드  |
| trustAtcCode          | string | 대표 ATC코드    |
| trustCancelName       | string | 취소/취하명      |
| cnsgnItemSeq          | string | 품목기준코드      |
| cnsgnItemName         | string | 제품명         |
| cnsgnEntpName         | string | 업소명         |
| cnsgnManuf            | string | 제조소         |
| cnsgnItemPermitDate   | string | 허가일자        |
| cnsgnHiraPrductCode   | string | 심평원제품코드     |
| cnsgnCancelName       | string | 취소/취하명      |

## 약가기준정보

### 약가목록조회

| name             | type   | description |
|------------------|--------|-------------|
| unit             | string | 단위          |
| adtStaDd         | string | 적용시작일자      |
| chgAfMdsCd       | string | 변경이후약품코드    |
| chgBfMdsCd       | string | 변경이전약품코드    |
| expTpTxt1        | string | 예외구분1       |
| expTpTxt2        | string | 예외구분2       |
| expTpTxt3        | string | 예외구분3       |
| gnlNmCd          | string | 일반명코드       |
| injcPthNm        | string | 투여경로명       |
| itmNm            | string | 품목명         |
| lprcEssAddcCuprc | string | 저가필수가산산출단가  |
| lprcEssTpNm      | string | 저가필수구분명     |
| mdsCd            | string | 제품코드        |
| meftDivNo        | string | 약효분류번호      |
| mnfEntpNm        | string | 제조업체명       |
| mxCprc           | string | 상한가         |
| nomNm            | string | 규격명         |
| optCpmdImplTpNm  | string | 임의조제불가능구분명  |
| payTpNm          | string | 급여구분명       |
| sbstPsblTpNm     | string | 대체가능구분명     |
| sellEptDd        | string | 판매예정일자      |
| spcGnlTpNm       | string | 전문일반구분명     |

## 회수 판매중지

### 목록

| name                | type   | description |
|---------------------|--------|-------------|
| PRDUCT              | string | 품목명         |
| ENTRPS              | string | 업체명         |
| RTRVL_RESN          | string | 회수사유내용      |
| ENFRC_YN            | string | 구분(강제여부)    |
| RTRVL_CMMND_DT      | string | 승인일자        |
| RECALL_COMMAND_DATE | string | 회수명령일자      |
| ITEM_SEQ            | string | 품목기준코드      |
| BIZRNO              | string | 사업자등록번호     |
| STD_CD              | string | 표준코드        |

### 상세

| name                | type   | description |
|---------------------|--------|-------------|
| ENTRPS              | string | 업체명         |
| ENTRPS_ADRES        | string | 공장주소        |
| ENTRPS_TELNO        | string | 업체담당자전화번호   |
| PRDUCT              | string | 품목명         |
| RTRVL_RESN          | string | 회수사유내용      |
| MNFCTUR_NO          | string | 제조번호        |
| MNFCTUR_DT          | string | 제조일자        |
| USGPD               | string | 유효기간        |
| PACKNG_UNIT         | string | 포장단위        |
| RTRVL_CMMND_DT      | string | 승인일자        |
| RM                  | string | 비고          |
| RECALL_COMMAND_DATE | string | 회수명령일자      |
| OPEN_END_DATE       | string | 공개마감일       |
| BIZRNO              | string | 사업자등록번호     |
| STD_CD              | string | 표준코드        |
| ITEM_SEQ            | string | 품목기준코드      |

## 의약품 낱알식별 정보

| name                 | type   | description   |
|----------------------|--------|---------------|
| ITEM_SEQ             | string | 품목일련번호        |
| ITEM_NAME            | string | 품목명           |
| ENTP_SEQ             | string | 업체일련번호        |
| ENTP_NAME            | string | 업체명           |
| CHART                | string | 성상            |
| ITEM_IMAGE           | string | 큰제품이미지        |
| PRINT_FRONT          | string | 표시(앞)         |
| PRINT_BACK           | string | 표시(뒤)         |
| DRUG_SHAPE           | string | 의약품모양         |
| COLOR_CLASS1         | string | 색깔(앞)         |
| COLOR_CLASS2         | string | 색깔(뒤)         |
| LINE_FRONT           | string | 분할선(앞)        |
| LINE_BACK            | string | 분할선(뒤)        |
| LENG_LONG            | string | 크기(장축)        |
| LENG_SHORT           | string | 크기(단축)        |
| THICK                | string | 크기(두께)        |
| IMG_REGIST_TS        | string | 약학정보원 이미지 생성일 |
| CLASS_NO             | string | 분류번호          |
| CLASS_NAME           | string | 분류명           |
| ETC_OTC_NAME         | string | 전문/일반         |
| ITEM_PERMIT_DATE     | string | 품목허가일자        |
| FORM_CODE_NAME       | string | 제형코드이름        |
| MARK_CODE_FRONT_ANAL | string | 마크내용(앞)       |
| MARK_CODE_BACK_ANAL  | string | 마크내용(뒤)       |
| MARK_CODE_FRONT_IMG  | string | 마크이미지(앞)      |
| MARK_CODE_BACK_IMG   | string | 마크이미지(뒤)      |
| ITEM_ENG_NAME        | string | 품목영문명         |
| CHANGE_DATE          | string | 변경일           |
| MARK_CODE_FRONT      | string | 마크코드(앞)       |
| MARK_CODE_BACK       | string | 마크코드(뒤)       |
| EDI_CODE             | string | 보험코드          |
| BIZRNO               | string | 사업자등록번호       |
| STD_CD               | string | 표준코드          |

## 의약품안전사용서비스(DUR)성분정보

### DUR성분정보의 병용금기 정보

| name                     | type   | description   |
|--------------------------|--------|---------------|
| DUR_SEQ                  | string | DUR일련번호       |
| TYPE_CODE                | string | DUR유형코드       |
| TYPE_NAME                | string | DUR유형         |
| MIX                      | string | 단일/복합         |
| INGR_CODE                | string | DUR성분코드       |
| INGR_KOR_NAME            | string | DUR성분         |
| INGR_ENG_NAME            | string | DUR성분(영문)     |
| MIX_INGR                 | string | 복합제           |
| ITEM_SEQ                 | string | 품목기준코드        |
| ITEM_NAME                | string | 품목명           |
| ENTP_NAME                | string | 업체명           |
| CHART                    | string | 성상            |
| FORM_CODE                | string | 제형구분코드        |
| ETC_OTC_CODE             | string | 전문일반 구분코드     |
| CLASS_CODE               | string | 약효분류코드        |
| FORM_NAME                | string | 제형            |
| ETC_OTC_NAME             | string | 전문/일반         |
| CLASS_NAME               | string | 약효분류          |
| MAIN_INGR                | string | 주성분           |
| MIXTURE_DUR_SEQ          | string | 병용금기DUR번호     |
| MIXTURE_MIX              | string | 병용금기복합제       |
| MIXTURE_INGR_CODE        | string | 병용금기DUR성분코드   |
| MIXTURE_INGR_KOR_NAME    | string | 병용금기DUR성분     |
| MIXTURE_INGR_ENG_NAME    | string | 병용금기DUR성분(영문) |
| MIXTURE_ITEM_SEQ         | string | 병용금기품목기준코드    |
| MIXTURE_ITEM_NAME        | string | 병용금기품목명       |
| MIXTURE_ENTP_NAME        | string | 병용금기업체명       |
| MIXTURE_FORM_CODE        | string | 병용금기제형구분코드    |
| MIXTURE_ETC_OTC_CODE     | string | 병용금기전문일반구분코드  |
| MIXTURE_CLASS_CODE       | string | 병용금기약효분류코드    |
| MIXTURE_FORM_NAME        | string | 병용금기제형        |
| MIXTURE_ETC_OTC_NAME     | string | 병용금기전문/일반     |
| MIXTURE_CLASS_NAME       | string | 병용금기약효분류      |
| MIXTURE_MAIN_INGR        | string | 병용금기주성분       |
| NOTIFICATION_DATE        | string | 고시일자          |
| PROHBT_CONTENT           | string | 금기내용          |
| REMARK                   | string | 비고            |
| ITEM_PERMIT_DATE         | string | 품목허가일자        |
| MIXTURE_ITEM_PERMIT_DATE | string | 병용금기품목허가일자    |
| MIXTURE_CHART            | string | 병용금기성상        |
| CHANGE_DATE              | string | 변경일자          |
| MIXTURE_CHANGE_DATE      | string | 병용변경일자        |

### DUR성분정보의 임부금기 정보

| name               | type   | description |
|--------------------|--------|-------------|
| TYPE_NAME          | string | DUR유형       |
| MIX_TYPE           | string | 단일/복합구분     |
| INGR_CODE          | string | DUR성분코드     |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| INGR_NAME          | string | DUR성분(한글)   |
| MIX_INGR           | string | 복합제         |
| FORM_NAME          | string | 형태          |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| ENTP_NAME          | string | 업체명         |
| CHART              | string | 성상          |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| ETC_OTC_NAME       | string | 전문/일반       |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 용량주의 정보

| name               | type   | description |
|--------------------|--------|-------------|
| TYPE_NAME          | string | DUR유형       |
| MIX_TYPE           | string | 단일/복합구분     |
| INGR_CODE          | string | DUR성분코드     |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| INGR_NAME          | string | DUR성분(한글)   |
| MIX_INGR           | string | 복합제         |
| FORM_NAME          | string | 형태          |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| ENTP_NAME          | string | 업체명         |
| CHART              | string | 성상          |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| ETC_OTC_NAME       | string | 전문/일반       |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 투여기간주의 정보

| name               | type   | description |
|--------------------|--------|-------------|
| TYPE_NAME          | string | DUR유형       |
| MIX_TYPE           | string | 단일/복합구분     |
| INGR_CODE          | string | DUR성분코드     |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| INGR_NAME          | string | DUR성분(한글)   |
| MIX_INGR           | string | 복합제         |
| FORM_NAME          | string | 형태          |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| ENTP_NAME          | string | 업체명         |
| CHART              | string | 성상          |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| ETC_OTC_NAME       | string | 전문/일반       |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 노인주의 정보

| name               | type   | description |
|--------------------|--------|-------------|
| TYPE_NAME          | string | DUR유형       |
| MIX_TYPE           | string | 단일/복합구분     |
| INGR_CODE          | string | DUR성분코드     |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| INGR_NAME          | string | DUR성분(한글)   |
| MIX_INGR           | string | 복합제         |
| FORM_NAME          | string | 형태          |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| ENTP_NAME          | string | 업체명         |
| CHART              | string | 성상          |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| ETC_OTC_NAME       | string | 전문/일반       |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 특정연령대금기 정보

| name               | type   | description |
|--------------------|--------|-------------|
| TYPE_NAME          | string | DUR유형       |
| MIX_TYPE           | string | 단일/복합구분     |
| INGR_CODE          | string | DUR성분코드     |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| INGR_NAME          | string | DUR성분(한글)   |
| MIX_INGR           | string | 복합제         |
| FORM_NAME          | string | 형태          |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| ENTP_NAME          | string | 업체명         |
| CHART              | string | 성상          |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| ETC_OTC_NAME       | string | 전문/일반       |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 효능군중복 정보

| name               | type   | description |
|--------------------|--------|-------------|
| DUR_SEQ            | string | DUR일련번호     |
| EFFECT_NAME        | string | 효능          |
| TYPE_NAME          | string | DUR유형       |
| INGR_CODE          | string | DUR성분코드     |
| INGR_NAME          | string | 성분명         |
| INGR_ENG_NAME      | string | DUR성분(영문)   |
| FORM_CODE_NAME     | string | 제형구분        |
| MIX                | string | 단일/복합       |
| MIX_INGR           | string | 복합제         |
| ITEM_SEQ           | string | 품목기준코드      |
| ITEM_NAME          | string | 품목명         |
| ITEM_PERMIT_DATE   | string | 품목허가일자      |
| CHART              | string | 성상          |
| ENTP_NAME          | string | 업체명         |
| FORM_CODE          | string | 제형구분코드      |
| FORM_NAME          | string | 제형          |
| ETC_OTC_CODE       | string | 전문일반 구분코드   |
| ETC_OTC_NAME       | string | 전문/일반       |
| CLASS_CODE         | string | 약효분류코드      |
| CLASS_NAME         | string | 약효분류        |
| MAIN_INGR          | string | 주성분         |
| NOTIFICATION_DATE  | string | 고시일자        |
| PROHBT_CONTENT     | string | 금기내용        |
| REMARK             | string | 비고          |
| INGR_ENG_NAME_FULL | string | DUR성분상세명    |
| CHANGE_DATE        | string | 변경일자        |

### DUR성분정보의 서방정분할주의 정보

| name             | type   | description |
|------------------|--------|-------------|
| TYPE_NAME        | string | DUR유형       |
| ITEM_SEQ         | string | 품목기준코드      |
| ITEM_NAME        | string | 품목명         |
| ITEM_PERMIT_DATE | string | 품목허가일자      |
| FORM_CODE_NAME   | string | 제형코드이름      |
| ENTP_NAME        | string | 업체명         |
| CHART            | string | 성상          |
| CLASS_CODE       | string | 약효분류코드      |
| CLASS_NAME       | string | 약효분류        |
| ETC_OTC_NAME     | string | 전문/일반       |
| MIX              | string | 단일/복합       |
| MAIN_INGR        | string | 주성분         |
| PROHBT_CONTENT   | string | 금기내용        |
| REMARK           | string | 비고          |
| CHANGE_DATE      | string | 변경일자        |

## DUR 정보 분석

### 공통 항목

| name              | used_in                                                 | comments           | count |
|-------------------|---------------------------------------------------------|--------------------|-------|
| CHANGE_DATE       | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 7     |
| CHART             | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| CLASS_CODE        | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| CLASS_NAME        | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| ENTP_NAME         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| ETC_OTC_NAME      | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| FORM_NAME         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 | FORM_CODE_NAME와 동일 | 7     |
| INGR_CODE         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복          |                    | 7     |
| INGR_ENG_NAME     | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복          |                    | 7     |
| INGR_NAME         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복          |                    | 7     |
| ITEM_NAME         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| ITEM_PERMIT_DATE  | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| ITEM_SEQ          | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| MAIN_INGR         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| MIX               | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 | MIX_TYPE 과 동일      | 3     |
| MIX_INGR          | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복          |                    | 7     |
| NOTIFICATION_DATE | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복          |                    | 7     |
| PROHBT_CONTENT    | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| REMARK            | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |
| TYPE_NAME         | 병용금기, 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복, 서방정분할주의 |                    | 8     |

### 데이터별 고유 항목

| name                     | used_in                                  | comments      |
|--------------------------|------------------------------------------|---------------|
| INGR_KOR_NAME            | 병용금기                                     | INGR_NAME과 동일 |
| MIXTURE_CHANGE_DATE      | 병용금기                                     |               |
| MIXTURE_CHART            | 병용금기                                     |               |
| MIXTURE_CLASS_CODE       | 병용금기                                     |               |
| MIXTURE_CLASS_NAME       | 병용금기                                     |               |
| MIXTURE_DUR_SEQ          | 병용금기                                     |               |
| MIXTURE_ENTP_NAME        | 병용금기                                     |               |
| MIXTURE_ETC_OTC_CODE     | 병용금기                                     |               |
| MIXTURE_ETC_OTC_NAME     | 병용금기                                     |               |
| MIXTURE_FORM_CODE        | 병용금기                                     |               |
| MIXTURE_FORM_NAME        | 병용금기                                     |               |
| MIXTURE_INGR_CODE        | 병용금기                                     |               |
| MIXTURE_INGR_ENG_NAME    | 병용금기                                     |               |
| MIXTURE_INGR_KOR_NAME    | 병용금기                                     |               |
| MIXTURE_ITEM_NAME        | 병용금기                                     |               |
| MIXTURE_ITEM_PERMIT_DATE | 병용금기                                     |               |
| MIXTURE_ITEM_SEQ         | 병용금기                                     |               |
| MIXTURE_MAIN_INGR        | 병용금기                                     |               |
| TYPE_CODE                | 병용금기                                     | 삭제 가능         |
| EFFECT_NAME              | 효능군중복                                    |               | 
| DUR_SEQ                  | 병용금기, 효능군중복                              |               |
| FORM_CODE                | 병용금기, 효능군중복                              |               |
| ETC_OTC_CODE             | 병용금기, 효능군중복                              |               |
| INGR_ENG_NAME_FULL       | 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기, 효능군중복 |               |
| FORM_CODE_NAME           | 서방정분할주의                                  | FORM_NAME과 동일 |
| MIX_TYPE                 | 임부금기, 용량주의, 투여기간주의, 노인주의, 특정연령대금기        | MIX와 동일       |
