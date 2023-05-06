export default{
    state:{
        // 控制菜单栏的状态
        isCollapse:false,
    },
    mutations:{
        collapseChange(state){
            state.isCollapse = !state.isCollapse
        }
    }
}