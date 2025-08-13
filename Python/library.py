import tkinter as tk
from tkinter import messagebox, ttk
import json
import os
from datetime import datetime
import platform

class LibraryApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Library Management System with Calculator")
        self.root.geometry("800x500")

        # System Name and Current Date & Time
        system_name = platform.node()
        current_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        
        self.system_info_label = tk.Label(root, text=f"System: {system_name} - Started at: {current_time}", font=("Arial", 10), anchor="w")
        self.system_info_label.pack(side=tk.TOP, fill=tk.X, padx=5, pady=5)

        # Load book data from file
        self.book_data = []
        self.load_books()

        # Book List Display
        self.book_list = ttk.Treeview(root, columns=("Title", "Author", "Price", "Availability"), show="headings")
        self.book_list.heading("Title", text="Title")
        self.book_list.heading("Author", text="Author")
        self.book_list.heading("Price", text="Price")
        self.book_list.heading("Availability", text="Availability")
        self.book_list.pack(fill=tk.BOTH, expand=True)

        # Status Message
        self.status_label = tk.Label(root, text="", bd=1, relief=tk.SUNKEN, anchor=tk.W)
        self.status_label.pack(side=tk.BOTTOM, fill=tk.X)

        # Buttons Frame for Library Functions
        button_frame = tk.Frame(self.root)
        button_frame.pack(pady=10)

        button_style = {"bg": "light blue", "fg": "black", "activebackground": "blue", "width": 15, "height": 2}

        tk.Button(button_frame, text="Add Book", command=self.add_book_window, **button_style).grid(row=0, column=0, padx=5, pady=5)
        tk.Button(button_frame, text="Remove Book", command=self.remove_book_window, **button_style).grid(row=0, column=1, padx=5, pady=5)
        tk.Button(button_frame, text="Price List", command=self.show_price_list, **button_style).grid(row=0, column=2, padx=5, pady=5)
        tk.Button(button_frame, text="Calculate Fine", command=self.calculate_fine, **button_style).grid(row=0, column=3, padx=5, pady=5)
        tk.Button(button_frame, text="Reset", command=self.reset, **button_style).grid(row=0, column=4, padx=5, pady=5)
        tk.Button(button_frame, text="Exit", command=self.exit_app, **button_style).grid(row=0, column=5, padx=5, pady=5)

        # Calculator Section
        self.calculator_entry = tk.Entry(self.root, width=30, borderwidth=3, font=('Arial', 12))
        self.calculator_entry.pack(pady=20)

        calc_button_frame = tk.Frame(self.root)
        calc_button_frame.pack()

        buttons = [
            '7', '8', '9', '/', 
            '4', '5', '6', '*', 
            '1', '2', '3', '-', 
            '0', '.', '=', '+'
        ]
        
        row = 0
        col = 0
        for button in buttons:
            action = lambda x=button: self.click(x)
            tk.Button(calc_button_frame, text=button, width=5, height=2, command=action).grid(row=row, column=col, padx=5, pady=5)
            col += 1
            if col > 3:
                col = 0
                row += 1

        # Refresh Book List
        self.update_book_list()

    # Save and Load Book Data
    def save_books(self):
        with open("books.json", "w") as f:
            json.dump(self.book_data, f)

    def load_books(self):
        if os.path.exists("books.json"):
            with open("books.json", "r") as f:
                self.book_data = json.load(f)

    # Add Book Function
    def add_book_window(self):
        add_win = tk.Toplevel(self.root)
        add_win.title("Add Book")
        tk.Label(add_win, text="Title:").grid(row=0, column=0)
        title_entry = tk.Entry(add_win)
        title_entry.grid(row=0, column=1)

        tk.Label(add_win, text="Author:").grid(row=1, column=0)
        author_entry = tk.Entry(add_win)
        author_entry.grid(row=1, column=1)

        tk.Label(add_win, text="Price:").grid(row=2, column=0)
        price_entry = tk.Entry(add_win)
        price_entry.grid(row=2, column=1)

        def add_book():
            title = title_entry.get()
            author = author_entry.get()
            price = price_entry.get()
            if title and author and price:
                self.book_data.append({"Title": title, "Author": author, "Price": price, "Availability": "Available"})
                self.update_book_list()
                self.save_books()  # Save to file after adding book
                self.status_label.config(text="Book added successfully!")
                add_win.destroy()
            else:
                messagebox.showerror("Error", "All fields are required")

        tk.Button(add_win, text="Add", command=add_book, **button_style).grid(row=3, column=1)

    # Remove Book Function
    def remove_book_window(self):
        remove_win = tk.Toplevel(self.root)
        remove_win.title("Remove Book")
        tk.Label(remove_win, text="Title:").grid(row=0, column=0)
        title_entry = tk.Entry(remove_win)
        title_entry.grid(row=0, column=1)

        def remove_book():
            title = title_entry.get()
            for book in self.book_data:
                if book["Title"] == title:
                    self.book_data.remove(book)
                    self.update_book_list()
                    self.save_books()  # Save to file after removing book
                    self.status_label.config(text="Book removed successfully!")
                    remove_win.destroy()
                    return
            messagebox.showerror("Error", "Book not found")

        tk.Button(remove_win, text="Remove", command=remove_book, **button_style).grid(row=1, column=1)

    # Update Book List (UI Refresh)
    def update_book_list(self):
        for i in self.book_list.get_children():
            self.book_list.delete(i)
        for book in self.book_data:
            self.book_list.insert("", tk.END, values=(book["Title"], book["Author"], book["Price"], book["Availability"]))

    # Show Price List
    def show_price_list(self):
        price_win = tk.Toplevel(self.root)
        price_win.title("Price List")
        price_list = ttk.Treeview(price_win, columns=("Title", "Price"), show="headings")
        price_list.heading("Title", text="Title")
        price_list.heading("Price", text="Price")
        price_list.pack(fill=tk.BOTH, expand=True)
        for book in self.book_data:
            price_list.insert("", tk.END, values=(book["Title"], book["Price"]))

    # Reset System (Clear book list)
    def reset(self):
        self.book_data = []
        self.update_book_list()
        self.save_books()  # Save empty list to file
        self.status_label.config(text="Library Reset")

    # Exit Application
    def exit_app(self):
        self.root.quit()

    # Calculator Functions
    def click(self, button):
        if button == '=':
            try:
                result = str(eval(self.calculator_entry.get()))
                self.calculator_entry.delete(0, tk.END)
                self.calculator_entry.insert(tk.END, result)
            except:
                self.calculator_entry.delete(0, tk.END)
                self.calculator_entry.insert(tk.END, "Error")
        else:
            self.calculator_entry.insert(tk.END, button)

    # Calculate Fine (Basic Version)
    def calculate_fine(self):
        fine_win = tk.Toplevel(self.root)
        fine_win.title("Calculate Fine")
        tk.Label(fine_win, text="Days Late:").grid(row=0, column=0)
        days_entry = tk.Entry(fine_win)
        days_entry.grid(row=0, column=1)

        def calculate():
            days = int(days_entry.get())
            fine = days * 5  # Assume fine is 5 units per day
            messagebox.showinfo("Fine", f"The fine is: {fine}")

        tk.Button(fine_win, text="Calculate", command=calculate, **button_style).grid(row=1, column=1)

# Create the main window
root = tk.Tk()
app = LibraryApp(root)
root.mainloop()
