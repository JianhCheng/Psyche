export default{
    state:{
        username:localStorage.getItem('username')||'',
        userhead:localStorage.getItem('userhead')||'',
        email:localStorage.getItem('email')||'',
        mobile:localStorage.getItem('mobile')||'',
        age:localStorage.getItem('age')||'',
        sex:localStorage.getItem('sex')||'',
        intro:localStorage.getItem('intro')||'',

    },
    mutations:{
        setUserName(state,username){
            state.username=username
        },
        setUserHead(state,userhead){
            state.userhead=userhead
        },
        setEmail(state,email){
            state.email=email
        },
        setMobile(state,mobile){
            state.mobile=mobile
        },
        setAge(state,age){
            state.age=age
        },
        setSex(state,sex){
            state.sex=sex
        },
        setIntro(state,intro){
            state.intro=intro
        },
    },
    getters:{
        getUserName(state){
            return state.username
        },
        getUserHead(state){
            return state.userhead
        },
        getEmail(state){
            return state.email
        },
        getMobile(state){
            return state.mobile
        },
        getAge(state){
            return state.age
        },
        getSex(state){
            return state.sex
        },
        getIntro(state){
            return state.intro
        },
    }
}