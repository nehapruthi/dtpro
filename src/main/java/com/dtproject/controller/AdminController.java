
package com.dtproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dtproject.model.Category;
import com.dtproject.model.Product;
import com.dtproject.model.Supplier;
import com.dtproject.model.User;
import com.dtproject.service.CategoryService;
import com.dtproject.service.ProductService;
import com.dtproject.service.SupplierService;

@Controller
public class AdminController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/admin/adding")
	public ModelAndView adding() {
		ModelAndView mv=new ModelAndView();
		Product product=new Product();
		Category category=new Category();
		Supplier supplier=new Supplier();
		
		mv.addObject("pro", product);
		mv.addObject("cat", category);
		mv.addObject("sup", supplier);
		
		ArrayList<Category> categoryList=(ArrayList<Category>) categoryService.getAllCategories();
		ArrayList<Supplier> supplierList=(ArrayList<Supplier>) supplierService.getAllSuppliers();
		
		mv.addObject("supList", supplierList);
		mv.addObject("catList", categoryList);
		mv.setViewName("adding");
		return mv;
	}
	
	@RequestMapping(value="/admin/saveCategory",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category)
	{
		categoryService.saveCategory(category);
		return "redirect:/admin/adding";
	}
	
	@RequestMapping("/admin/addProduct")
	public ModelAndView addProduct()
	{
		System.out.println("add product");
		ModelAndView mv=new ModelAndView();
		Product product=new Product();
		//Category category=new Category();
		//Supplier supplier=new Supplier();
		
		mv.addObject("pro", product);
		//mv.addObject("cat", category);
		//mv.addObject("sup", supplier);
		
		ArrayList<Category> categoryList=(ArrayList<Category>) categoryService.getAllCategories();
		ArrayList<Supplier> supplierList=(ArrayList<Supplier>) supplierService.getAllSuppliers();
		
		mv.addObject("supList", supplierList);
		mv.addObject("catList", categoryList);
		mv.setViewName("addProduct");
		return mv;
	}
	
	@RequestMapping("/admin/addCategory")
	public ModelAndView addCategory()
	{
		ModelAndView mv=new ModelAndView();
		Category category=new Category();
		
		mv.addObject("cat",category);
		mv.setViewName("addCategory");
		return mv;
		
	}
	
	@RequestMapping("/admin/addSupplier")
	public ModelAndView addSupplier()
	{
		ModelAndView mv=new ModelAndView();
		Supplier supplier=new Supplier();
		
		mv.addObject("sup",supplier);
		mv.setViewName("addSupplier");
		return mv;
		
	}
	
	@RequestMapping(value="/admin/saveProduct",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product, @RequestParam("pfile") MultipartFile mfile)
	{
		System.out.println(product.getpName());
		
		String filename=mfile.getOriginalFilename();
		String rootPath="D:\\dtpro\\src\\main\\webapp\\WEB-INF\\Resources\\images";
		
		if(!mfile.isEmpty())
		{
			try {
				byte b[]=mfile.getBytes();
				File f=new File(rootPath+File.separator+filename);
				
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(b);
				bos.close();
				fos.close();
				System.out.println("File image saved successfully");
				product.setpImg(filename);
			}
			catch(Exception e) {
				System.out.println("Exception: "+e);	
			}
		}
		productService.saveProduct(product);
		return "redirect:/admin/addProduct";
	}
	
	@RequestMapping(value="/admin/saveSupplier",method=RequestMethod.POST)
	public String saveSupplier(@ModelAttribute Supplier supplier)
	{
		supplierService.saveSupplier(supplier);
		return "redirect:/admin/adding";
	}
	
	@RequestMapping("/admin/showCategory")
	public ModelAndView showCategory(ModelAndView m)
	{
		List<Category> category=categoryService.getAllCategories();
		m.addObject("catList", category);
		m.setViewName("showCategory");
		return m;
	}
	
	@RequestMapping("/admin/showSuppliers")
	public ModelAndView showSupplier(ModelAndView m)
	{
		List<Supplier> supplier=supplierService.getAllSuppliers();
		m.addObject("supList", supplier);
		m.setViewName("showSuppliers");
		return m;
	}
	
	@RequestMapping("/admin/showProducts")
	public ModelAndView showProducts(ModelAndView m)
	{
		List<Product> product=productService.getAllProducts();
		m.addObject("prodList", product);
		m.setViewName("showProducts");
		return m;
	}
	
	@RequestMapping("/listProducts")
	public ModelAndView listProducts(ModelAndView m)
	{
		List<Product> product=productService.getAllProducts();
		m.addObject("prodList", product);
		m.setViewName("products");
		return m;
	}

	
	@RequestMapping("/admin/deleteProduct/{pId}")
	public String deleteProduct(@PathVariable("pId") int productId)
	{
		productService.deleteProduct(productId);
		return "redirect:/admin/showProducts";
	}
	
	@RequestMapping("/admin/deleteCategory/{cId}")
	public String deleteCategory(@PathVariable("cId") int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return "redirect:/admin/showCategory";
	}
	
	@RequestMapping("/admin/deleteSupplier/{sId}")
	public String deleteSupplier(@PathVariable("sId") int supplierId)
	{
		supplierService.deleteSupplier(supplierId);
		return "redirect:/admin/showSuppliers";
	}
	
	@RequestMapping("/admin/updateProduct/{pId}")
	public ModelAndView updateProduct(@PathVariable("pId") int productId)
	{
		ModelAndView m=new ModelAndView();
		Product product=productService.findProductById(productId);
		ArrayList<Category> categoryList=(ArrayList<Category>) categoryService.getAllCategories();
		ArrayList<Supplier> supplierList=(ArrayList<Supplier>) supplierService.getAllSuppliers();
		
		m.addObject("supList", supplierList);
		m.addObject("catList", categoryList);
		
		m.addObject("pro",product);
		m.setViewName("updateProduct");
		
		return m;
	}
	
	@RequestMapping(value="/admin/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("pro") Product product,BindingResult result,@RequestParam("pfile") MultipartFile mfile)
	{
		if(result.hasErrors()) {
			System.out.println("we found an error");
		}

		String filename=mfile.getOriginalFilename();
		String rootPath="D:\\dtpro\\src\\main\\webapp\\WEB-INF\\Resources\\images";
		
		if(!mfile.isEmpty())
		{
			try {
				byte b[]=mfile.getBytes();
				File f=new File(rootPath+File.separator+filename);
				
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(b);
				bos.close();
				fos.close();
				System.out.println("File image saved successfully");
				product.setpImg(filename);
			}
			catch(Exception e) {
				System.out.println("Exception: "+e);	
			}
		}
	
		System.out.println("updateProduct save product");
		productService.updateProduct(product);
		return "redirect:/admin/showProducts";
	}
	
	@RequestMapping("/admin/updateCategory/{cId}")
	public ModelAndView updateCategory(@PathVariable("cId") int categoryId)
	{
		ModelAndView m=new ModelAndView();
		Category category=categoryService.findCategoryById(categoryId);	
		m.addObject("cat",category);
		m.setViewName("updateCategory");
		
		return m;

	}
	
	@RequestMapping(value="/admin/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@ModelAttribute("cat") Category category)
	{
		categoryService.updateCategory(category);
		return "redirect:/admin/showCategory";
		
	}
	
	@RequestMapping("/admin/updateSupplier/{sId}")
	public ModelAndView updateSupplier(@PathVariable("sId") int supplierId)
	{
		ModelAndView m=new ModelAndView();
		Supplier supplier=supplierService.findCategoryById(supplierId);	
		m.addObject("sup",supplier);
		m.setViewName("updateSupplier");
		
		return m;

	}
	
	@RequestMapping(value="/admin/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("sup") Supplier supplier)
	{
		supplierService.updateSupplier(supplier);
		return "redirect:/admin/showSuppliers";
		
	}
	
	@RequestMapping("/admin/adminOptions")
	public ModelAndView adminOptions()
	{
		System.out.println("admin options page");
		ModelAndView mv=new ModelAndView();
		  mv.setViewName("adminOptions");
		  return mv;
	}
	
	
	
}
