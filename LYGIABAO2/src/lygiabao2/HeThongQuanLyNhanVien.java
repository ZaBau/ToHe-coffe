
package lygiabao2;
    import java.util.Scanner;
    import java.util.ArrayList;

public class HeThongQuanLyNhanVien {

    public static void main(String[] args) {
        System.out.println("He Thong Quan Ly Nhan Vien");
        System.out.println("==========================");
        QLNV qlnv = new QLNV();
        while(true){
            System.out.println("1.Them nhan vien");
            System.out.println("2.Tim kiem nhan vien");
            System.out.println("3.Hien thi nhan vien");
            System.out.println("4.Xoa nhan vien");
            System.out.println("5.Tong luong toan bo nhan vien");
            System.out.println("6.Thoat chuong trinh");
            System.out.print("Moi chon: ");
            Scanner sc = new Scanner(System.in);
            String chon = sc.nextLine();
            System.out.println("==========================");
            switch(chon){
                case "1":
                    System.out.print("Nhap so nhan vien: ");
                    int n = sc.nextInt(); sc.nextLine();
                    for(int i = 0; i < n; i++){
                        System.out.println("Nhan vien thu "+(i+1));
                        System.out.print("Nhap ma nhan vien: ");
                        String manv = sc.nextLine();
                        System.out.print("Nhap ho ten: ");
                        String hoten = sc.nextLine();
                        System.out.print("Nhap gioi tinh: ");
                        String gioitinh = sc.nextLine();
                        System.out.print("Nhap chung minh nhan dan: ");
                        String cmnd = sc.nextLine();
                        System.out.print("Nhap dia chi: ");
                        String diachi = sc.nextLine();
                        System.out.print("Nhap so tuoi: ");
                        int tuoi = sc.nextInt(); sc.nextLine();
                        System.out.print("Nhap chuc vu: ");
                        String chucvu = sc.nextLine();
                        System.out.print("Nhap so gio lam: ");
                        int sogiolam = sc.nextInt();
                        System.out.print("Nhap luong: ");
                        double luong = sc.nextInt();
                        qlnv.ThemNV(hoten, gioitinh, cmnd, diachi, tuoi, manv, chucvu, sogiolam, luong);
                    }
                    break;
                case "2":
                    System.out.print("Nhap so chung minh nhan dan can tim: ");
                    String search = sc.nextLine();
                    NhanVien obj = qlnv.TimKiemNhanVien(search);
                    if(obj != null){
                        
                    }
                    else{
                        System.out.println("Khong tim thay nhan vien!");
                    }
                    break;
                case "3":
                    qlnv.HienThi();
                    break;
                case "4":
                    System.out.print("Nhap so chung minh dan can xoa: ");
                    String delete = sc.nextLine();
                    obj = qlnv.TimKiemNhanVien(delete);
                    if(obj != null){
                        qlnv.XoaNV(delete);
                        System.out.println("Xoa thanh cong!");
                    }
                    else{
                        System.out.println("Khong tim thay nhan vien can xoa!");
                    }
                    break;
                case "5":
                    System.out.println("Tong luong toan bo nhan vien la: "+qlnv.tongLuongNV());
                    break;
                case "6":
                    return;
    }
        }
}
}
class Nguoi{
    public String hoten, gioitinh, cmnd, diachi;
    public int tuoi;
    
    public Nguoi(){
        
    }
    public Nguoi(String hoten, String gioitinh, String cmnd, String diachi, int tuoi){
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.tuoi = tuoi;
    }
    
    public String gethoten(){
        return hoten;
    }
    public void sethoten(String hoten){
        this.hoten = hoten;
    }
    
    public String getgioitinh(){
        return gioitinh;
    }
    public void setgioitinh(String gioitinh){
        this.gioitinh = gioitinh;
    }
    
    public String getcmnd(){
        return cmnd;
    }
    public void setcmnd(String cmnd){
        this.cmnd = cmnd;
    }
    
    public String getdiachi(){
        return diachi;
    }
    public void setdiachi(String diachi){
        this.diachi = diachi;
    }
    
    public int gettuoi(){
        return tuoi;
    }
    public void settuoi(int tuoi){
        this.tuoi = tuoi;
    }
}


class NhanVien extends Nguoi{
    protected String manv, chucvu;
    protected int sogiolam;
    protected double luong;
    
    public NhanVien(String hoten, String gioitinh, String cmnd, String diachi, int tuoi, String manv, String chucvu, int sogiolam, double luong){
        super( hoten,  gioitinh,  cmnd,  diachi,  tuoi);
        this.manv = manv;
        this.chucvu = chucvu;
        this.sogiolam = sogiolam;
        this.luong = luong;
    }
    
    public String getmanv(){
        return manv;
    }
    public void setmanv(String manv){
        this.manv = manv;
    }
    
    
    public String getchucvu(){
        return chucvu;
    }
    public void setchucvu(String chucvu){
        this.chucvu = chucvu;
    }
    
    public int getsogiolam(){
        return sogiolam;
    }
    public void setsogiolam(int sogiolam){
        this.sogiolam = sogiolam;
    }
    
    public double getluong(){
        return luong;
    }
    public void setluong(double luong){
        this.luong = luong;
    }
    
    public double tinhThuong(){
        if(sogiolam >= 200){
            return luong * 0.2;
        }
        if(sogiolam < 200 && sogiolam >= 100){
            return luong * 0.1;
        }
        if(sogiolam < 100){
            return 0;
        }
        return 0;
    }
    
    public double tinhPhuCap(){
        double phucap;
        if(chucvu.compareTo("GD") == 0){
            return phucap = 500000;
        }
        if(chucvu.compareTo("PGD") == 0){
            return phucap = 400000;
        }
        else{
            return phucap = 300000;
        }
    }
    
    public double tongLuong(){
        return luong + tinhThuong() + tinhPhuCap();
    }
    
    @Override
    public String toString(){
        return "Ma nhan vien: "+manv+"\nHo ten: "+hoten+"\nGioi tinh: "+gioitinh+"\nChung minh nhan dan: "+cmnd+"\nDia chi: "+diachi+"\nTuoi: "+tuoi+"\nChuc vu: "+chucvu+"\nSo gio lam: "+sogiolam+"\nLuong: "+luong+"\nTien thuong: "+tinhThuong()+"\nTien phu cap: "+tinhPhuCap()+"\nTong luong nhan vien: "+tongLuong();
    }
}

class QLNV{
    ArrayList<NhanVien> DanhSachNV = new ArrayList<NhanVien>();
    public void ThemNV(String hoten, String gioitinh, String cmnd, String diachi, int tuoi, String manv, String chucvu, int sogiolam, double luong){
        NhanVien NV = new NhanVien( hoten,  gioitinh,  cmnd, diachi,  tuoi,  manv,  chucvu,  sogiolam,  luong);
        this.DanhSachNV.add(NV);
    }
    
    public void HienThi(){
        this.DanhSachNV.forEach(a->System.out.println(a.toString()));
    }
    
    public NhanVien TimKiemNhanVien(String cmnd){
        for(NhanVien a: this.DanhSachNV){
            if(a.getcmnd().toLowerCase().equals(cmnd.toLowerCase())){
                System.out.println(a.toString());
                return a;
            }
        }
        return null;
    }
    
    public void XoaNV(String cmnd){
        int i = 0;
        for(i = 0; i < this.DanhSachNV.size(); i++){
            if(this.DanhSachNV.get(i).getcmnd().toLowerCase().equals(cmnd.toLowerCase())){
                break;
            }
        }
        this.DanhSachNV.remove(i);
    }
    
    public double tongLuongNV(){
        double tong = 0;
        for(int i = 0; i < this.DanhSachNV.size(); i++){
            tong += this.DanhSachNV.get(i).tongLuong();
        }
        return tong;
    }
    
}
