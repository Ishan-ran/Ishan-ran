from tkinter import *
import tkinter.messagebox as messagebox

# Create the main window
supermarket = Tk()
supermarket.geometry("1350x650")
supermarket.resizable(0, 0)
supermarket.title("Supermarket Billing System")

# Define functions
def exit():
    supermarket.destroy()

def reset():
    Item1.set("")
    Item2.set("")
    Item3.set("")
    Item4.set("")
    Item5.set("")
    Item1Price.set("")
    Item2Price.set("")
    Item3Price.set("")
    Item4Price.set("")
    Item5Price.set("")
    Item1Qty.set("")
    Item2Qty.set("")
    Item3Qty.set("")
    Item4Qty.set("")
    Item5Qty.set("")
    TotalPrice.set("")
    GST.set("")
    FinalTotal.set("")

def calculate_bill():
    try:
        qty1 = float(Item1Qty.get())
        qty2 = float(Item2Qty.get())
        qty3 = float(Item3Qty.get())
        qty4 = float(Item4Qty.get())
        qty5 = float(Item5Qty.get())
        price1 = float(Item1Price.get())
        price2 = float(Item2Price.get())
        price3 = float(Item3Price.get())
        price4 = float(Item4Price.get())
        price5 = float(Item5Price.get())

        total = (qty1 * price1) + (qty2 * price2) + (qty3 * price3) + (qty4 * price4) + (qty5 * price5)
        GST = total * 0.05
        final_total = total + GST

        TotalPrice.set(f"${total:.2f}")
        GST.set(f"${GST:.2f}")
        FinalTotal.set(f"${final_total:.2f}")

    except ValueError:
        messagebox.showinfo("Error", "Invalid input! Please enter numbers for quantities and prices.")
        reset()

# Define variables
Item1 = StringVar()
Item2 = StringVar()
Item3 = StringVar()
Item4 = StringVar()
Item5 = StringVar()
Item1Price = StringVar()
Item2Price = StringVar()
Item3Price = StringVar()
Item4Price = StringVar()
Item5Price = StringVar()
Item1Qty = StringVar()
Item2Qty = StringVar()
Item3Qty = StringVar()
Item4Qty = StringVar()
Item5Qty = StringVar()
TotalPrice = StringVar()
GST = StringVar()
FinalTotal = StringVar()

# Create Frames
Tops = Frame(supermarket, width=1350, height=50, bd=16, relief="raise")
Tops.pack(side=TOP)

LF = Frame(supermarket, width=700, height=650, bd=12, relief="raise")
LF.pack(side=LEFT)

RF = Frame(supermarket, width=600, height=650, bd=12, relief="raise")
RF.pack(side=RIGHT)

# Title
lblTitle = Label(Tops, font=('arial', 50, 'bold'), text="Supermarket Billing System", fg="black", bd=10, anchor="w")
lblTitle.grid(row=0, column=0)

# Left Frame (Items and Prices)
InsideLF = Frame(LF, width=700, height=600, bd=8, relief="raise")
InsideLF.pack(side=TOP)

lblItem1 = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 1", fg="black", bd=10, anchor="w")
lblItem1.grid(row=0, column=0)
txtItem1 = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=20, bg="gray", justify="left", textvariable=Item1)
txtItem1.grid(row=0, column=1)
lblItem1Price = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 1 Price", fg="black", bd=10, anchor="w")
lblItem1Price.grid(row=0, column=2)
txtItem1Price = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item1Price)
txtItem1Price.grid(row=0, column=3)
lblItem1Qty = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 1 Qty", fg="black", bd=10, anchor="w")
lblItem1Qty.grid(row=0, column=4)
txtItem1Qty = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item1Qty)
txtItem1Qty.grid(row=0, column=5)

lblItem2 = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 2", fg="black", bd=10, anchor="w")
lblItem2.grid(row=1, column=0)
txtItem2 = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=20, bg="gray", justify="left", textvariable=Item2)
txtItem2.grid(row=1, column=1)
lblItem2Price = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 2 Price", fg="black", bd=10, anchor="w")
lblItem2Price.grid(row=1, column=2)
txtItem2Price = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item2Price)
txtItem2Price.grid(row=1, column=3)
lblItem2Qty = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 2 Qty", fg="black", bd=10, anchor="w")
lblItem2Qty.grid(row=1, column=4)
txtItem2Qty = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item2Qty)
txtItem2Qty.grid(row=1, column=5)

lblItem3 = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 3", fg="black", bd=10, anchor="w")
lblItem3.grid(row=2, column=0)
txtItem3 = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=20, bg="gray", justify="left", textvariable=Item3)
txtItem3.grid(row=2, column=1)
lblItem3Price = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 3 Price", fg="black", bd=10, anchor="w")
lblItem3Price.grid(row=2, column=2)
txtItem3Price = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item3Price)
txtItem3Price.grid(row=2, column=3)
lblItem3Qty = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 3 Qty", fg="black", bd=10, anchor="w")
lblItem3Qty.grid(row=2, column=4)
txtItem3Qty = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item3Qty)
txtItem3Qty.grid(row=2, column=5)

lblItem4 = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 4", fg="black", bd=10, anchor="w")
lblItem4.grid(row=3, column=0)
txtItem4 = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=20, bg="gray", justify="left", textvariable=Item4)
txtItem4.grid(row=3, column=1)
lblItem4Price = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 4 Price", fg="black", bd=10, anchor="w")
lblItem4Price.grid(row=3, column=2)
txtItem4Price = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item4Price)
txtItem4Price.grid(row=3, column=3)
lblItem4Qty = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 4 Qty", fg="black", bd=10, anchor="w")
lblItem4Qty.grid(row=3, column=4)
txtItem4Qty = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item4Qty)
txtItem4Qty.grid(row=3, column=5)

lblItem5 = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 5", fg="black", bd=10, anchor="w")
lblItem5.grid(row=4, column=0)
txtItem5 = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=20, bg="gray", justify="left", textvariable=Item5)
txtItem5.grid(row=4, column=1)
lblItem5Price = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 5 Price", fg="black", bd=10, anchor="w")
lblItem5Price.grid(row=4, column=2)
txtItem5Price = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item5Price)
txtItem5Price.grid(row=4, column=3)
lblItem5Qty = Label(InsideLF, font=('arial', 12, 'bold'), text="Item 5 Qty", fg="black", bd=10, anchor="w")
lblItem5Qty.grid(row=4, column=4)
txtItem5Qty = Entry(InsideLF, font=('arial', 12, 'bold'), bd=20, width=10, bg="gray", justify="right", textvariable=Item5Qty)
txtItem5Qty.grid(row=4, column=5)

# Right Frame (Total and Buttons)
InsideRF = Frame(RF, width=600, height=200, bd=8, relief="raise")
InsideRF.pack(side=TOP)

lblTotalPrice = Label(InsideRF, font=('arial', 12, 'bold'), text="Total Price", fg="black", bd=10, anchor="w")
lblTotalPrice.grid(row=0, column=0)
txtTotalPrice = Entry(InsideRF, font=('arial', 12, 'bold'), bd=20, width=18, bg="gray", justify="right", textvariable=TotalPrice)
txtTotalPrice.grid(row=0, column=1)

lblGST= Label(InsideRF, font=('arial', 12, 'bold'), text="GST", fg="black", bd=10, anchor="w")
lblGST.grid(row=1, column=0)
txtGST = Entry(InsideRF, font=('arial', 12, 'bold'), bd=20, width=18, bg="gray", justify="right", textvariable=GST)
txtGST .grid(row=1, column=1)

lblFinalTotal = Label(InsideRF, font=('arial', 12, 'bold'), text="Final Total", fg="black", bd=10, anchor="w")
lblFinalTotal.grid(row=2, column=0)
txtFinalTotal = Entry(InsideRF, font=('arial', 12, 'bold'), bd=20, width=18, bg="gray", justify="right", textvariable=FinalTotal)
txtFinalTotal.grid(row=2, column=1)

InsideRF2 = Frame(RF, width=600, height=200, bd=8, relief="raise")
InsideRF2.pack(side=BOTTOM)

btnTotal = Button(InsideRF2, padx=16, pady=8, bd=10, fg="black", font=('arial', 12, 'bold'), width=10, text="Total", bg="gray", command=calculate_bill)
btnTotal.grid(row=0, column=0)

btnReset = Button(InsideRF2, padx=16, pady=8, bd=10, fg="black", font=('arial', 12, 'bold'), width=10, text="Reset", bg="gray", command=reset)
btnReset.grid(row=0, column=1)

btnExit = Button(InsideRF2, padx=16, pady=8, bd=10, fg="black", font=('arial', 12, 'bold'), width=10, text="Exit", bg="gray", command=exit)
btnExit.grid(row=0, column=2)

supermarket.mainloop()
