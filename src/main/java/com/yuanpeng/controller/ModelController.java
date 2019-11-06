package com.yuanpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
/* lay-href="   lay-href="*[ctxPath]/model/
*.html
*../../../layuiadmin/
* *[ctxPath]/
*
* */
@Controller
@RequestMapping("model")
public class ModelController {

    @GetMapping("/app/content/comment")
    public String appcontentcomment(Model model, HttpServletRequest request){
        return "layuiModel/app/content/comment";
    }

    @GetMapping("/app/content/contform")
    public String appcontentcontform(Model model, HttpServletRequest request){
        return "layuiModel/app/content/contform";
    }

    @GetMapping("/app/content/list")
    public String appcontentlist(Model model, HttpServletRequest request){
        return "layuiModel/app/content/list";
    }

    @GetMapping("/app/content/listform")
    public String appcontentlistform(Model model, HttpServletRequest request){
        return "layuiModel/app/content/listform";
    }

    @GetMapping("/app/content/tags")
    public String appcontenttags(Model model, HttpServletRequest request){
        return "layuiModel/app/content/tags";
    }

    @GetMapping("/app/content/tagsform")
    public String appcontenttagsform(Model model, HttpServletRequest request){
        return "layuiModel/app/content/tagsform";
    }

    @GetMapping("/app/forum/list")
    public String appforumlist(Model model, HttpServletRequest request){
        return "layuiModel/app/forum/list";
    }

    @GetMapping("/app/forum/listform")
    public String appforumlistform(Model model, HttpServletRequest request){
        return "layuiModel/app/forum/listform";
    }

    @GetMapping("/app/forum/replys")
    public String appforumreplys(Model model, HttpServletRequest request){
        return "layuiModel/app/forum/replys";
    }

    @GetMapping("/app/forum/replysform")
    public String appforumreplysform(Model model, HttpServletRequest request){
        return "layuiModel/app/forum/replysform";
    }

    @GetMapping("/app/mall/category")
    public String appmallcategory(Model model, HttpServletRequest request){
        return "layuiModel/app/mall/category";
    }

    @GetMapping("/app/mall/list")
    public String appmalllist(Model model, HttpServletRequest request){
        return "layuiModel/app/mall/list";
    }

    @GetMapping("/app/mall/specs")
    public String appmallspecs(Model model, HttpServletRequest request){
        return "layuiModel/app/mall/specs";
    }

    @GetMapping("/app/message/detail")
    public String appmessagedetail(Model model, HttpServletRequest request){
        return "layuiModel/app/message/detail";
    }

    @GetMapping("/app/message/index")
    public String appmessageindex(Model model, HttpServletRequest request){
        return "layuiModel/app/message/index";
    }

    @GetMapping("/app/workorder/list")
    public String appworkorderlist(Model model, HttpServletRequest request){
        return "layuiModel/app/workorder/list";
    }

    @GetMapping("/app/workorder/listform")
    public String appworkorderlistform(Model model, HttpServletRequest request){
        return "layuiModel/app/workorder/listform";
    }

    @GetMapping("/component/anim/index")
    public String componentanimindex(Model model, HttpServletRequest request){
        return "layuiModel/component/anim/index";
    }

    @GetMapping("/component/auxiliar/index")
    public String componentauxiliarindex(Model model, HttpServletRequest request){
        return "layuiModel/component/auxiliar/index";
    }

    @GetMapping("/component/badge/index")
    public String componentbadgeindex(Model model, HttpServletRequest request){
        return "layuiModel/component/badge/index";
    }

    @GetMapping("/component/button/index")
    public String componentbuttonindex(Model model, HttpServletRequest request){
        return "layuiModel/component/button/index";
    }

    @GetMapping("/component/carousel/index")
    public String componentcarouselindex(Model model, HttpServletRequest request){
        return "layuiModel/component/carousel/index";
    }

    @GetMapping("/component/code/index")
    public String componentcodeindex(Model model, HttpServletRequest request){
        return "layuiModel/component/code/index";
    }

    @GetMapping("/component/flow/index")
    public String componentflowindex(Model model, HttpServletRequest request){
        return "layuiModel/component/flow/index";
    }

    @GetMapping("/component/form/element")
    public String componentformelement(Model model, HttpServletRequest request){
        return "layuiModel/component/form/element";
    }

    @GetMapping("/component/form/group")
    public String componentformgroup(Model model, HttpServletRequest request){
        return "layuiModel/component/form/group";
    }

    @GetMapping("/component/grid/all")
    public String componentgridall(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/all";
    }

    @GetMapping("/component/grid/list")
    public String componentgridlist(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/list";
    }

    @GetMapping("/component/grid/mobile-pc")
    public String componentgridmobilepc(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/mobile-pc";
    }

    @GetMapping("/component/grid/mobile")
    public String componentgridmobile(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/mobile";
    }

    @GetMapping("/component/grid/speed-dial")
    public String componentgridspeeddial(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/speed-dial";
    }

    @GetMapping("/component/grid/stack")
    public String componentgridstack(Model model, HttpServletRequest request){
        return "layuiModel/component/grid/stack";
    }

    @GetMapping("/component/laydate/demo1")
    public String componentlaydatedemo1(Model model, HttpServletRequest request){
        return "layuiModel/component/laydate/demo1";
    }

    @GetMapping("/component/laydate/demo2")
    public String componentlaydatedemo2(Model model, HttpServletRequest request){
        return "layuiModel/component/laydate/demo2";
    }

    @GetMapping("/component/laydate/index")
    public String componentlaydateindex(Model model, HttpServletRequest request){
        return "layuiModel/component/laydate/index";
    }

    @GetMapping("/component/laydate/special-demo")
    public String componentlaydatespecialdemo(Model model, HttpServletRequest request){
        return "layuiModel/component/laydate/special-demo";
    }

    @GetMapping("/component/laydate/theme")
    public String componentlaydatetheme(Model model, HttpServletRequest request){
        return "layuiModel/component/laydate/theme";
    }

    @GetMapping("/component/layer/list")
    public String componentlayerlist(Model model, HttpServletRequest request){
        return "layuiModel/component/layer/list";
    }

    @GetMapping("/component/layer/special-demo")
    public String componentlayerspecialdemo(Model model, HttpServletRequest request){
        return "layuiModel/component/layer/special-demo";
    }

    @GetMapping("/component/layer/theme")
    public String componentlayertheme(Model model, HttpServletRequest request){
        return "layuiModel/component/layer/theme";
    }

    @GetMapping("/component/laypage/demo1")
    public String componentlaypagedemo1(Model model, HttpServletRequest request){
        return "layuiModel/component/laypage/demo1";
    }

    @GetMapping("/component/laypage/demo2")
    public String componentlaypagedemo2(Model model, HttpServletRequest request){
        return "layuiModel/component/laypage/demo2";
    }

    @GetMapping("/component/laypage/index")
    public String componentlaypageindex(Model model, HttpServletRequest request){
        return "layuiModel/component/laypage/index";
    }

    @GetMapping("/component/laytpl/index")
    public String componentlaytplindex(Model model, HttpServletRequest request){
        return "layuiModel/component/laytpl/index";
    }

    @GetMapping("/component/nav/index")
    public String componentnavindex(Model model, HttpServletRequest request){
        return "layuiModel/component/nav/index";
    }

    @GetMapping("/component/panel/index")
    public String componentpanelindex(Model model, HttpServletRequest request){
        return "layuiModel/component/panel/index";
    }

    @GetMapping("/component/progress/index")
    public String componentprogressindex(Model model, HttpServletRequest request){
        return "layuiModel/component/progress/index";
    }

    @GetMapping("/component/rate/index")
    public String componentrateindex(Model model, HttpServletRequest request){
        return "layuiModel/component/rate/index";
    }

    @GetMapping("/component/table/auto")
    public String componenttableauto(Model model, HttpServletRequest request){
        return "layuiModel/component/table/auto";
    }

    @GetMapping("/component/table/cellEdit")
    public String componenttablecellEdit(Model model, HttpServletRequest request){
        return "layuiModel/component/table/cellEdit";
    }

    @GetMapping("/component/table/cellEvent")
    public String componenttablecellEvent(Model model, HttpServletRequest request){
        return "layuiModel/component/table/cellEvent";
    }

    @GetMapping("/component/table/checkbox")
    public String componenttablecheckbox(Model model, HttpServletRequest request){
        return "layuiModel/component/table/checkbox";
    }

    @GetMapping("/component/table/data")
    public String componenttabledata(Model model, HttpServletRequest request){
        return "layuiModel/component/table/data";
    }

    @GetMapping("/component/table/fixed")
    public String componenttablefixed(Model model, HttpServletRequest request){
        return "layuiModel/component/table/fixed";
    }

    @GetMapping("/component/table/form")
    public String componenttableform(Model model, HttpServletRequest request){
        return "layuiModel/component/table/form";
    }

    @GetMapping("/component/table/height")
    public String componenttableheight(Model model, HttpServletRequest request){
        return "layuiModel/component/table/height";
    }

    @GetMapping("/component/table/index")
    public String componenttableindex(Model model, HttpServletRequest request){
        return "layuiModel/component/table/index";
    }

    @GetMapping("/component/table/initSort")
    public String componenttableinitSort(Model model, HttpServletRequest request){
        return "layuiModel/component/table/initSort";
    }

    @GetMapping("/component/table/operate")
    public String componenttableoperate(Model model, HttpServletRequest request){
        return "layuiModel/component/table/operate";
    }

    @GetMapping("/component/table/page")
    public String componenttablepage(Model model, HttpServletRequest request){
        return "layuiModel/component/table/page";
    }

    @GetMapping("/component/table/reload")
    public String componenttablereload(Model model, HttpServletRequest request){
        return "layuiModel/component/table/reload";
    }

    @GetMapping("/component/table/resetPage")
    public String componenttableresetPage(Model model, HttpServletRequest request){
        return "layuiModel/component/table/resetPage";
    }

    @GetMapping("/component/table/simple")
    public String componenttablesimple(Model model, HttpServletRequest request){
        return "layuiModel/component/table/simple";
    }

    @GetMapping("/component/table/static")
    public String componenttablestatic(Model model, HttpServletRequest request){
        return "layuiModel/component/table/static";
    }

    @GetMapping("/component/table/style")
    public String componenttablestyle(Model model, HttpServletRequest request){
        return "layuiModel/component/table/style";
    }

    @GetMapping("/component/table/thead")
    public String componenttablethead(Model model, HttpServletRequest request){
        return "layuiModel/component/table/thead";
    }

    @GetMapping("/component/table/tostatic")
    public String componenttabletostatic(Model model, HttpServletRequest request){
        return "layuiModel/component/table/tostatic";
    }

    @GetMapping("/component/tabs/index")
    public String componenttabsindex(Model model, HttpServletRequest request){
        return "layuiModel/component/tabs/index";
    }

    @GetMapping("/component/temp")
    public String componenttemp(Model model, HttpServletRequest request){
        return "layuiModel/component/temp";
    }

    @GetMapping("/component/timeline/index")
    public String componenttimelineindex(Model model, HttpServletRequest request){
        return "layuiModel/component/timeline/index";
    }

    @GetMapping("/component/upload/demo1")
    public String componentuploaddemo1(Model model, HttpServletRequest request){
        return "layuiModel/component/upload/demo1";
    }

    @GetMapping("/component/upload/demo2")
    public String componentuploaddemo2(Model model, HttpServletRequest request){
        return "layuiModel/component/upload/demo2";
    }

    @GetMapping("/component/upload/index")
    public String componentuploadindex(Model model, HttpServletRequest request){
        return "layuiModel/component/upload/index";
    }

    @GetMapping("/component/util/index")
    public String componentutilindex(Model model, HttpServletRequest request){
        return "layuiModel/component/util/index";
    }

    @GetMapping("/home/console")
    public String homeconsole(Model model, HttpServletRequest request){
        return "layuiModel/home/console";
    }

    @GetMapping("/home/homepage1")
    public String homehomepage1(Model model, HttpServletRequest request){
        return "layuiModel/home/homepage1";
    }

    @GetMapping("/home/homepage2")
    public String homehomepage2(Model model, HttpServletRequest request){
        return "layuiModel/home/homepage2";
    }

    @GetMapping("/iframe/layer/iframe")
    public String iframelayeriframe(Model model, HttpServletRequest request){
        return "layuiModel/iframe/layer/iframe";
    }

    @GetMapping("/senior/echarts/bar")
    public String seniorechartsbar(Model model, HttpServletRequest request){
        return "layuiModel/senior/echarts/bar";
    }

    @GetMapping("/senior/echarts/line")
    public String seniorechartsline(Model model, HttpServletRequest request){
        return "layuiModel/senior/echarts/line";
    }

    @GetMapping("/senior/echarts/map")
    public String seniorechartsmap(Model model, HttpServletRequest request){
        return "layuiModel/senior/echarts/map";
    }

    @GetMapping("/senior/im/index")
    public String seniorimindex(Model model, HttpServletRequest request){
        return "layuiModel/senior/im/index";
    }

    @GetMapping("/set/system/email")
    public String setsystememail(Model model, HttpServletRequest request){
        return "layuiModel/set/system/email";
    }

    @GetMapping("/set/system/website")
    public String setsystemwebsite(Model model, HttpServletRequest request){
        return "layuiModel/set/system/website";
    }

    @GetMapping("/set/user/info")
    public String setuserinfo(Model model, HttpServletRequest request){
        return "layuiModel/set/user/info";
    }

    @GetMapping("/set/user/password")
    public String setuserpassword(Model model, HttpServletRequest request){
        return "layuiModel/set/user/password";
    }

    @GetMapping("/system/about")
    public String systemabout(Model model, HttpServletRequest request){
        return "layuiModel/system/about";
    }

    @GetMapping("/system/get")
    public String systemget(Model model, HttpServletRequest request){
        return "layuiModel/system/get";
    }

    @GetMapping("/system/more")
    public String systemmore(Model model, HttpServletRequest request){
        return "layuiModel/system/more";
    }

    @GetMapping("/system/theme")
    public String systemtheme(Model model, HttpServletRequest request){
        return "layuiModel/system/theme";
    }

    @GetMapping("/template/addresslist")
    public String templateaddresslist(Model model, HttpServletRequest request){
        return "layuiModel/template/addresslist";
    }

    @GetMapping("/template/goodslist")
    public String templategoodslist(Model model, HttpServletRequest request){
        return "layuiModel/template/goodslist";
    }

    @GetMapping("/template/msgboard")
    public String templatemsgboard(Model model, HttpServletRequest request){
        return "layuiModel/template/msgboard";
    }

    @GetMapping("/template/personalpage")
    public String templatepersonalpage(Model model, HttpServletRequest request){
        return "layuiModel/template/personalpage";
    }

    @GetMapping("/template/search")
    public String templatesearch(Model model, HttpServletRequest request){
        return "layuiModel/template/search";
    }

    @GetMapping("/template/temp")
    public String templatetemp(Model model, HttpServletRequest request){
        return "layuiModel/template/temp";
    }

    @GetMapping("/template/tips/404")
    public String templatetips404(Model model, HttpServletRequest request){
        return "layuiModel/template/tips/404";
    }

    @GetMapping("/template/tips/error")
    public String templatetipserror(Model model, HttpServletRequest request){
        return "layuiModel/template/tips/error";
    }

    @GetMapping("/user/administrators/adminform")
    public String useradministratorsadminform(Model model, HttpServletRequest request){
        return "layuiModel/user/administrators/adminform";
    }

    @GetMapping("/user/administrators/list")
    public String useradministratorslist(Model model, HttpServletRequest request){
        return "layuiModel/user/administrators/list";
    }

    @GetMapping("/user/administrators/role")
    public String useradministratorsrole(Model model, HttpServletRequest request){
        return "layuiModel/user/administrators/role";
    }

    @GetMapping("/user/administrators/roleform")
    public String useradministratorsroleform(Model model, HttpServletRequest request){
        return "layuiModel/user/administrators/roleform";
    }

    @GetMapping("/user/forget")
    public String userforget(Model model, HttpServletRequest request){
        return "layuiModel/user/forget";
    }

    @GetMapping("/user/login")
    public String userlogin(Model model, HttpServletRequest request){
        return "layuiModel/user/login";
    }

    @GetMapping("/user/reg")
    public String userreg(Model model, HttpServletRequest request){
        return "layuiModel/user/reg";
    }

    @GetMapping("/user/user/list")
    public String useruserlist(Model model, HttpServletRequest request){
        return "layuiModel/user/user/list";
    }

    @GetMapping("/user/user/userform")
    public String useruseruserform(Model model, HttpServletRequest request){
        return "layuiModel/user/user/userform";
    }






    // 设置一个全局动态数组，来存放文件路径
    // 主要遍历文件夹，包含所有子文件夹、文件的情况时，用到递归，所以要这样设置
    public static ArrayList<String> dirAllStrArr = new ArrayList<String>();

    // 这里是仅仅查询当前路径下的所有文件夹、文件并且存放其路径到文件数组
    // 由于遇到文件夹不查询其包含所有子文件夹、文件，因此没必要用到递归
    public static ArrayList<String> Dir(File dirFile) throws Exception {
        ArrayList<String> dirStrArr = new ArrayList<String>();

        if (dirFile.exists()) {
            // 直接取出利用listFiles()把当前路径下的所有文件夹、文件存放到一个文件数组
            File files[] = dirFile.listFiles();
            for (File file : files) {
                // 如果传递过来的参数dirFile是以文件分隔符，也就是/或者/结尾，则如此构造
                if (dirFile.getPath().endsWith(File.separator)) {
                    dirStrArr.add(dirFile.getPath() + file.getName());
                } else {
                    // 否则，如果没有文件分隔符，则补上一个文件分隔符，再加上文件名，才是路径
                    dirStrArr.add(dirFile.getPath() + File.separator
                            + file.getName());
                }
            }
        }
        return dirStrArr;
    }

    public static void DirAll(File dirFile) throws Exception {

        if (dirFile.exists()) {
            File files[] = dirFile.listFiles();
            for (File file : files) {
                // 如果遇到文件夹则递归调用。
                if (file.isDirectory()) {
                    // 递归调用
                    DirAll(file);
                } else {
                    // 如果遇到文件夹则放入数组
                    if (dirFile.getPath().endsWith(File.separator)) {
                        dirAllStrArr.add(dirFile.getPath() + file.getName());
                    } else {
                        if(!file.getName().equals("说明.txt")){
                            dirAllStrArr.add(dirFile.getPath() + File.separator
                                    + file.getName());
                        }


                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        /*String path = "E://test.txt";
        String word = "试试";
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path,true)));
        out.write(word+"/r/n");
        out.close();*/
        String path = "E://test.txt";
        File dirFile = new File("E://IDEAWork//Two//customer-manage//src//main//resources//templates//layuiModel");
        try {
            System.out.println(Dir(dirFile));
            ModelController.DirAll(dirFile);
            for(int i = 0 ; i<dirAllStrArr.size();i++){
              /*  @GetMapping("/anim/index")
                public String animIndex(Model model, HttpServletRequest request){
                    return "component/anim/index";
                }*/
                String str1 = dirAllStrArr.get(i).substring(71,dirAllStrArr.get(i).length()-5);//请求名 /app/content/comment
                String str = dirAllStrArr.get(i).substring(61,dirAllStrArr.get(i).length()-5);//指向具体位置 layuiModel/app/content/comment

                String word = "@GetMapping(\""+str1+"\")";
                String word1 = "public String "+str1.replace("//","")+"(Model model, HttpServletRequest request){";
                String word2 = "return \""+str+"\";";
                String word3 = "}";
                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(path,true)));
                out.write(word+"/r/n"+word1+"/r/n"+word2+"/r/n"+word3+"/r/n/r/n");
                out.close();
            }




            //System.out.println(dirAllStrArr);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
